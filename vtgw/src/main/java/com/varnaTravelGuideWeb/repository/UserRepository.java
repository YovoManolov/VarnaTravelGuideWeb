package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.entity.User;


public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);
	User findByEmail(String email);
	
}
