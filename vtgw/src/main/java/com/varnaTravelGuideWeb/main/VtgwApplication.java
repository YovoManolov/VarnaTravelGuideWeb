package com.varnaTravelGuideWeb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


@SpringBootApplication
//@EnableOAuth2Sso
public class VtgwApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtgwApplication.class, args);
	}
}
