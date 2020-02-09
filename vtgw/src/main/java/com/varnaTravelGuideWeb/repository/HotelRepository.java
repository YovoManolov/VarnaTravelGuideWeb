package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel,String> {

}
