package com.varnaTravelGuideWeb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.varnaTravelGuideWeb.config.AppProperties;

@SpringBootApplication
@EnableOAuth2Sso
@EnableConfigurationProperties(AppProperties.class)
public class VtgwApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtgwApplication.class, args);
	}

}
