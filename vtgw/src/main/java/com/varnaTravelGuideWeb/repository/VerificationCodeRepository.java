package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.dao.Verification;

public interface VerificationCodeRepository extends MongoRepository<Verification, String>{
	
	Verification findByUsername(String username);
	boolean existsByUsername(String username);
}
