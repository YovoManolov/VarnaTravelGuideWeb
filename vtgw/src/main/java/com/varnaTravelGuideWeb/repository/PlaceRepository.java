package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.varnaTravelGuideWeb.model.Place;


@CrossOrigin(origins = "http://localhost:4200")
public interface PlaceRepository extends MongoRepository<Place, String> {
	
}
