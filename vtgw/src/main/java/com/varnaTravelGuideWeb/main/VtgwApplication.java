package com.varnaTravelGuideWeb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.varnaTravelGuideWeb.config.AppProperties;

//@EnableOAuth2Sso
@EnableConfigurationProperties//(AppProperties.class)
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={SecurityAutoConfiguration.class})
//@ComponentScan
public class VtgwApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtgwApplication.class, args);
	}

}
