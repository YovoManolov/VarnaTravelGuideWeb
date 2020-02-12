package com.varnaTravelGuideWeb.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="places")
public class Place {
	
	@Id
	@Field("_id")
	private String id;
	@Field("name")
    private String name;	
	@Field("address")
    private String address;
	@Field("latitude")
    private Double latitude;
	@Field("longitude")
    private Double longitude;
	@Field("contacts")
    private String contacts;
	@Field("description")
    private String description;
	@Field("typeOfPlace")
    private Integer typeOfPlace;
	@Field("priceCategory")
    private Integer priceCategoryId;
	@Field("images")
    private ArrayList<Image> images;
	@Field("workHours")
    private WorkHours workHours;
}
