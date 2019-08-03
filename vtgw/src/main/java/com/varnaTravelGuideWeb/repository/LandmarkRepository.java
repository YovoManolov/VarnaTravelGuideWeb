package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.model.Landmark;

public interface LandmarkRepository extends MongoRepository<Landmark, String> {

}

