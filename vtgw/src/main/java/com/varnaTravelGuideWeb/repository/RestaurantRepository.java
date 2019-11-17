package com.varnaTravelGuideWeb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.dao.RestaurantDAO;

public interface RestaurantRepository extends MongoRepository<RestaurantDAO, String> {

	Optional<RestaurantDAO> findByPlaceId(String placeId);
}
