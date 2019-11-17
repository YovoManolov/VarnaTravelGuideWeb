package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.dao.HotelDAO;

public interface HotelRepository extends MongoRepository<HotelDAO, String> {

	Optional<HotelDAO> findByPlaceId(String placeId);

} 
 