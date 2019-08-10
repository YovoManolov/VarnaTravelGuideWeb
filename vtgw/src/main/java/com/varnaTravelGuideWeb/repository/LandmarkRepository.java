package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.model.Landmark;

public interface LandmarkRepository extends MongoRepository<Landmark, String> {

	Optional<Landmark> findByPlaceId(String placeId);
 
}

