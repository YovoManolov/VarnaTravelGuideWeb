package com.varnaTravelGuideWeb.vtgw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages={"com.varnaTravelGuideWeb.*"})
@EnableMongoRepositories("com.varnaTravelGuideWeb.*") 
@EnableMongoAuditing
@SpringBootApplication
public class VtgwApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VtgwApplication.class, args);
	}
	
}
