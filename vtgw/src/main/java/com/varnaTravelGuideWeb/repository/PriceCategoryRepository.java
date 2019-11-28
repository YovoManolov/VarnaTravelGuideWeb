package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.model.PriceCategory;

public interface PriceCategoryRepository extends MongoRepository<PriceCategory, String> {
	
	Optional<PriceCategory> getPriceCategoryById(String priceCategoryId);
	
}