package com.varnaTravelGuideWeb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="restaurants")
public class Restaurant {
	
	@Id
	private String _id ;
	private ObjectId place_id;
    private String cuisine;
	@Transient
	private Place place;
}
