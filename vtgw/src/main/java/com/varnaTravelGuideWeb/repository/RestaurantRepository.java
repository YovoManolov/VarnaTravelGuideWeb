package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.model.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

}
