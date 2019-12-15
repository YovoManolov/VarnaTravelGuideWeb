package com.varnaTravelGuideWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.varnaTravelGuideWeb.service.CustomUserDetailsService;

@Configuration
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
	    auth.userDetailsService(userDetailsService)
	        .passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest()
 				.hasRole("USER").and()
 				.formLogin().loginPage("/login") // enable form based log in
 				.permitAll();
 	}
	
	/*
	 * @Override protected void configure(final HttpSecurity http) throws Exception
	 * {
	 * 
	 * http.authorizeRequests(). antMatchers("/", "login/*", "webjars/*",
	 * "еrror/**").permitAll()
	 * .antMatchers("/dashboard/**").hasAuthority("ADMIN").anyRequest().
	 * authenticated() .and().csrf().disable()
	 * .formLogin().successHandler(customizeAuthenticationSuccessHandler)
	 * .loginPage("/login").failureUrl("/login?error=true")
	 * .usernameParameter("email") .passwordParameter("password") .and().logout()
	 * .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	 * .logoutSuccessUrl("/").and().exceptionHandling();
	 * 
	 * }
	 */
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	 @Bean
	 public BCryptPasswordEncoder passwordEncoder(){ 
	        return new BCryptPasswordEncoder(); 
	 }
}
