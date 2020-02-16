package com.varnaTravelGuideWeb.model;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
    private BigDecimal latitude;
	@Field("longitude")
    private BigDecimal longitude;
	@Field("contacts")
    private String contacts;
	@Field("description")
    private String description;
	@Field("typeOfPlace")
    private Integer typeOfPlace;
	@Field("priceCategory")
    private Integer priceCategoryId;
    private ArrayList<Image> images;
    private WorkHours workHours;
}
