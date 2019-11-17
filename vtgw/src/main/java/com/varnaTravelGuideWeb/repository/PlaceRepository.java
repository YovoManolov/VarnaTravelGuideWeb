package com.varnaTravelGuideWeb.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.dao.PlaceDAO;


public interface PlaceRepository extends MongoRepository<PlaceDAO, String> {

	Optional<PlaceDAO> findById(String placeId); 
	
}
