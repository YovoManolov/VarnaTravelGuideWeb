package com.varnaTravelGuideWeb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.varnaTravelGuideWeb.model.utilModels.Image;
import com.varnaTravelGuideWeb.model.utilModels.WorkHours;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="places")
public class Place {
			
	@Id
	private String _id;
	@Field("name")
    private String name;	
	@Field("address")
    private String address;
	@Field("location")
	private GeoJsonPoint location;
	@Field("contacts")
    private String contacts;
	@Field("description")
    private String description;
	@Field("typeOfPlace")
    private int typeOfPlace;
	@Field("images")
    private List<Image> images;
	@Field("workHours")
    private WorkHours workHours;
	@Transient
	private PriceCategory priceCategory;
}
