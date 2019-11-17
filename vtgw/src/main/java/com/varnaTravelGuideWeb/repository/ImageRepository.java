package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varnaTravelGuideWeb.dao.ImageDAO;

public interface ImageRepository extends MongoRepository<ImageDAO, String> {

}

