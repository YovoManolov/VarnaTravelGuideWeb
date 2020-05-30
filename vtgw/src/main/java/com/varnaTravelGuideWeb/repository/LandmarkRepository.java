package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.varnaTravelGuideWeb.model.Landmark;


@CrossOrigin(origins = "http://localhost:4200")
public interface LandmarkRepository extends MongoRepository<Landmark,String> {

}
