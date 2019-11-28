package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.domain.User;


public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
	
}
