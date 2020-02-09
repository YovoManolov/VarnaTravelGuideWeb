package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.varnaTravelGuideWeb.model.Place;

public interface PlaceRepository extends MongoRepository<Place, String> {
	
}
