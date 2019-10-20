package com.varnaTravelGuideWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.varnaTravelGuideWeb.filters.TotpAuthenticationFilter;
import com.varnaTravelGuideWeb.userdetails.AdditionalAuthenticationDetailsSource;
import com.varnaTravelGuideWeb.userdetails.AdditionalAuthenticationProvider;
import com.varnaTravelGuideWeb.userdetails.AuthenticationSuccessHandlerImpl;

@Configuration
@EnableWebSecurity(debug = true)
//@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired private AdditionalAuthenticationProvider additionalProvider;
	 * 
	 * @Autowired private TotpAuthenticationFilter totpAuthFilter;
	 * 
	 * @Autowired private AccessDeniedHandler accessDeniedHandler;
	 * 
	 * @Autowired private UserDetailsService userDetailsService;
	 * 
	 * @Autowired private PersistentTokenRepository persistentTokenRepository;
	 */
	/*
	 * @Autowired
	 * 
	 * @Qualifier("oauth2authSuccessHandler") private AuthenticationSuccessHandler
	 * oauth2authSuccessHandler;
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("./**").permitAll()
		 	.anyRequest().authenticated();
		
	}
	
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	      auth
	         .inMemoryAuthentication()
	         .withUser("user").password("password").roles("USER");
	 }
}
