package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.model.Image;

public interface ImageRepository extends MongoRepository<Image, String> {

}

