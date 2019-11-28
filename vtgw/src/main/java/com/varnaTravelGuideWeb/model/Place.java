package com.varnaTravelGuideWeb.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Place {
	
	@Id
	@Field("_id")
	private String id;
    private String name;	
    private String address;
    private Double latitude;
    private Double longitude;
    private String contacts;
    private String description;
    private Integer typeOfPlace;
    private Integer priceCategoryId;
    private ArrayList<Image> images;
    private WorkHours workHours;

	
}
