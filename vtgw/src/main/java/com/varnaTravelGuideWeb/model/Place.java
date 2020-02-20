package com.varnaTravelGuideWeb.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.client.model.geojson.Point;

import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToOne;
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
	@Field("location")
	private Point location;
	@Field("contacts")
    private String contacts;
	@Field("description")
    private String description;
	@Field("typeOfPlace")
    private int typeOfPlace;
    @OneToOne(fetch=FetchType.EAGER)
    @JoinProperty(name = "priceCategory")
    private PriceCategory priceCategory;
    private ArrayList<Image> images;
    private WorkHours workHours;
}
