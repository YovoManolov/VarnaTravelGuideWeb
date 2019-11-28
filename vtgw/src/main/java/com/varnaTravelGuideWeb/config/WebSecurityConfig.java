package com.varnaTravelGuideWeb.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.varnaTravelGuideWeb.service.CustomUserDetailsService;

@Configuration
@ComponentScan("com.varnaTravelGuideWeb")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
    private final ObjectMapper objectMapper ;

	public WebSecurityConfig( ObjectMapper objectMapper) {
	     this.objectMapper = objectMapper;
    }
	
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

		   http.authorizeRequests()
		   .antMatchers("/").permitAll()
		   .antMatchers("/login").permitAll()
		   .antMatchers("/signup").permitAll()
		   .antMatchers("/home/**").hasAnyAuthority("ADMIN","USER")
		   .anyRequest().authenticated()
		   .and().csrf().disable()
		   .formLogin().loginPage("/login")
		   .failureUrl("/login?error=true")
		   .defaultSuccessUrl("/home")
           .usernameParameter("email")
           .passwordParameter("password")
           .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))     
           .logoutSuccessUrl("/").and()
           .exceptionHandling()
           .accessDeniedPage("/error");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring()
	        .antMatchers("/resources/**", "/static/**", "/css/**",
	        				"/js/**", "/images/**","/templates/**" );
	}
	
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {  
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/public/templates/");
	 }
	 
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder(){ 
	        return new BCryptPasswordEncoder(); 
	 }
}
