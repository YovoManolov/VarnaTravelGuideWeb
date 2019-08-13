package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.PriceCategory;


public interface PlaceRepository extends MongoRepository<Place, String> {

	Optional<Place> findById(String placeId); 
	
}
