package com.varnaTravelGuideWeb.config;

import com.varnaTravelGuideWeb.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@ComponentScan("com.varnaTravelGuideWeb")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
 	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;
	
	@Bean
	public UserDetailsService mongoUserDetails() {
	    return new CustomUserDetailsService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    UserDetailsService userDetailsService = mongoUserDetails();
	    auth
	        .userDetailsService(userDetailsService)
	        .passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		   http.
		    csrf().disable()
           .authorizeRequests()
           .antMatchers("/signup/*").permitAll()
           .antMatchers("/dashboard/**").hasAuthority("ADMIN")
           .anyRequest().authenticated().
           and()
           	.formLogin().successHandler(customizeAuthenticationSuccessHandler)
           .loginPage("/login").failureUrl("/login?error=true")
           .usernameParameter("email")
           .passwordParameter("password")
           .and().logout()
           .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
           .logoutSuccessUrl("/").and().exceptionHandling();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring()
	        .antMatchers("/resources/**", "/static/**", "/css/**",
	        				"/js/**", "/images/**","/templates/**" );
	}

	 public void addResourceHandlers(ResourceHandlerRegistry registry) {  
		registry.addResourceHandler("/resources/**").addResourceLocations("/vtgw/src/main/resources/");
	 }
	 
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder(){ 
	        return new BCryptPasswordEncoder(); 
	 }
}
