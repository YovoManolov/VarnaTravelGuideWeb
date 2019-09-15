package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.entity.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

	Optional<Hotel> findByPlaceId(String placeId);

} 
 