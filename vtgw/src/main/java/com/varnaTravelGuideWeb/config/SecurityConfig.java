package com.varnaTravelGuideWeb.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;	

@Configuration
@EnableWebSecurity(debug = true)
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter  {	

    @Override
    protected void configure(HttpSecurity http) throws Exception {

         http.antMatcher("/**").authorizeRequests()
         .antMatchers( "/index.html", "/home.html", "/login.html", "/", "/access",
        		 "/logout","/callback/","/webjars/**","/error**")
         					.permitAll().anyRequest().authenticated()
         ;
    }
}
