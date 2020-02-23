package com.varnaTravelGuideWeb.vtgw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.github.kaiso.relmongo.config.EnableRelMongo;

@ComponentScan(basePackages={"com.varnaTravelGuideWeb.*"})
@EnableMongoAuditing
@EnableRelMongo
@EnableMongoRepositories("com.varnaTravelGuideWeb.*") 
@SpringBootApplication
public class VtgwApplication {
	public static void main(String[] args) {
		SpringApplication.run(VtgwApplication.class, args);
	}
}
