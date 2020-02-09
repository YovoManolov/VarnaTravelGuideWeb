package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@RequiredArgsConstructor
public class Restaurant {
	
	@Id
	private String _id ;
	@Field("place_id")
    private String placeId;
    private String cuisine;
}
