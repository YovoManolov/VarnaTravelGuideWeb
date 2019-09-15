package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.entity.PersistentLoginToken;

public interface PersistentLoginsTokenRespository extends MongoRepository<PersistentLoginToken, String> {

	PersistentLoginToken findBySeries(String series);
	PersistentLoginToken findByUsername(String username);
	
}
