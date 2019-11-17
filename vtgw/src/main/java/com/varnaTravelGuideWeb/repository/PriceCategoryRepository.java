package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.dao.PriceCategoryDAO;

public interface PriceCategoryRepository extends MongoRepository<PriceCategoryDAO, String> {
	
	Optional<PriceCategoryDAO> getPriceCategoryById(String priceCategoryId);
	
}