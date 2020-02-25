package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Restaurant {
	
	@Id
	private String _id ;
	private String place_id;
	private Place place;
	private PriceCategory priceCategory;
    private String cuisine;
}
