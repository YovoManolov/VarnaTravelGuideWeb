package com.varnaTravelGuideWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.varnaTravelGuideWeb.filters.TotpAuthenticationFilter;
import com.varnaTravelGuideWeb.model.Authorities;
import com.varnaTravelGuideWeb.userdetails.AdditionalAuthenticationDetailsSource;
import com.varnaTravelGuideWeb.userdetails.AdditionalAuthenticationProvider;
import com.varnaTravelGuideWeb.userdetails.AuthenticationSuccessHandlerImpl;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.mvcMatchers("/register","/index**","/login**","/login-error").permitAll().anyRequest().authenticated()
			.and()
            .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/login")
			.successHandler(myAuthenticationSuccessHandler());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/webjars/**");
	}
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new AuthenticationSuccessHandlerImpl();
	}

	@Bean
	public RedirectStrategy getRedirectStrategy() {
		return new DefaultRedirectStrategy();
	}
	
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder(){ 
	        return new BCryptPasswordEncoder(); 
	 }
}
