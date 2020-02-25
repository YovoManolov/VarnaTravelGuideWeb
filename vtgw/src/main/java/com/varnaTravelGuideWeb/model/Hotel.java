package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@AllArgsConstructor
@Document(collection="hotels")
public class Hotel {
		
		@Id
	    private String _id ;
		private String place_id;
		private Place place;
		@Transient
		private PriceCategory priceCategory;
	    private int numbOfStars;
}
