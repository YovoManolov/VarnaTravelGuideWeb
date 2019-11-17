package com.varnaTravelGuideWeb.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Document
@Getter
@RequiredArgsConstructor
public class RestaurantDAO {
	
	@Id
	private String _id ;
	@Field("place_id")
    private String placeId;
    private String cuisine;
}
