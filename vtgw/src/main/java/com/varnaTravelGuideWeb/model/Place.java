package com.varnaTravelGuideWeb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.ManyToOne;
import io.github.kaiso.relmongo.annotation.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	private GeoJsonPoint location;
	@Field("contacts")
    private String contacts;
	@Field("description")
    private String description;
	@Field("typeOfPlace")
    private int typeOfPlace;
	@ManyToOne(mappedBy="places")	
    private PriceCategory priceCategory;
//    @OneToOne(mappedBy = "place", fetch = FetchType.EAGER)
//    private Hotel hotel;
//    @OneToOne(mappedBy = "place", fetch = FetchType.EAGER)
//    private Landmark landmark;
//    @OneToOne(mappedBy = "place", fetch = FetchType.EAGER)
//    private Restaurant restaurant;
	@Field("images")
    private List<Image> images;
	@Field("workHours")
    private WorkHours workHours;
}
