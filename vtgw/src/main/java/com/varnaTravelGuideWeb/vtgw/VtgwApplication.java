package com.varnaTravelGuideWeb.vtgw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages={"com.varnaTravelGuideWeb.*"})
@EnableMongoRepositories("com.varnaTravelGuideWeb.*") 
@SpringBootApplication
public class VtgwApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VtgwApplication.class, args);
	}
	
//	@Bean
//    CommandLineRunner init(RoleRepository roleRepository) {
//
//        return args -> {
//
//            Role adminRole = roleRepository.findByRole("ADMIN");
//            if (adminRole == null) {
//                Role newAdminRole = new Role();
//                newAdminRole.setRole("ADMIN");
//                roleRepository.save(newAdminRole);
//            }
//            
//            Role userRole = roleRepository.findByRole("USER");
//            if (userRole == null) {
//                Role newUserRole = new Role();
//                newUserRole.setRole("USER");
//                roleRepository.save(newUserRole);
//            }
//        };
//
//    }

}
