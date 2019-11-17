package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.dao.LandmarkDAO;

public interface LandmarkRepository extends MongoRepository<LandmarkDAO, String> {

	Optional<LandmarkDAO> findByPlaceId(String placeId);
 
}

