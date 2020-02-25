package com.varnaTravelGuideWeb.model.utilModels;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Image {
	
		@Field("imageURL")
	 	private String imageURL;
		@Field("mainImage")
	    private Integer mainImage;
}
