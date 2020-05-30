package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.varnaTravelGuideWeb.model.Restaurant;


@CrossOrigin(origins = "http://localhost:4200")
public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

}
