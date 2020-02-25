package com.varnaTravelGuideWeb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document
public class PriceCategory {
		
		@Id
	 	private String _id;
	    private String description;
	    private List<Place> places;
}
