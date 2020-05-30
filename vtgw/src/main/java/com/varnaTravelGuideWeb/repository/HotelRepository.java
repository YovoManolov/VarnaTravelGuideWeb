package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.varnaTravelGuideWeb.model.Hotel;

@CrossOrigin(origins = "http://localhost:4200")
public interface HotelRepository extends MongoRepository<Hotel,String> {

}
