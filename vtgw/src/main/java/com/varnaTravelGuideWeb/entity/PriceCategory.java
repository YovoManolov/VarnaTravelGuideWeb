package com.varnaTravelGuideWeb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Document
public class PriceCategory {
		
		@Id
		@Field("_id")
	 	private String id;
	    private Integer priceCategory_id ;
	    private String description;

	    public PriceCategory(){}
	    public PriceCategory(String description) {
	        this.description = description;
	    }
}
