package com.varnaTravelGuideWeb.vtgw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.varnaTravelGuideWeb.domain.Role;
import com.varnaTravelGuideWeb.repository.RoleRepository;

@SpringBootApplication
@EnableMongoRepositories("com.varnaTravelGuideWeb") 
public class VtgwApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtgwApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(RoleRepository roleRepository) {

        return args -> {

            Role adminRole = roleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setRole("ADMIN");
                roleRepository.save(newAdminRole);
            }
            
            Role userRole = roleRepository.findByRole("USER");
            if (userRole == null) {
                Role newUserRole = new Role();
                newUserRole.setRole("USER");
                roleRepository.save(newUserRole);
            }
        };

    }

}
