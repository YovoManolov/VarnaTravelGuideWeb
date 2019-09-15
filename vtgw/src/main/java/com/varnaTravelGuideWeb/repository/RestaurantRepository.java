package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.entity.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

	Optional<Restaurant> findByPlaceId(String placeId);
}
