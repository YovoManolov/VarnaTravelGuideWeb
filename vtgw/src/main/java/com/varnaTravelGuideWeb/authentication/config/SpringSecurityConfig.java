package com.varnaTravelGuideWeb.authentication.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
@EnableResourceServer
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests().anyRequest().authenticated()
        .and()
        .oauth2ResourceServer().jwt();
		
		
		/*
		 * http.requiresChannel() .requestMatchers(RequestMatcher { r ->
		 * r.getHeader("X-Forwarded-Proto") != null }).requiresSecure()
		 */

		/*
		 * http.csrf()
		 * .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		 * 
		 * http.headers()
		 * .contentSecurityPolicy("script-src 'self'; report-to /csp-report-endpoint/");
		 */ 
	}
	
}