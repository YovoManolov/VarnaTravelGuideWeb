package com.varnaTravelGuideWeb.dao;

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
public class PriceCategoryDAO {
		
		@Id
		@Field("_id")
	 	private String id;
	    private Integer priceCategory_id ;
	    private String description;

	    public PriceCategoryDAO(){}
	    public PriceCategoryDAO(String description) {
	        this.description = description;
	    }
}
