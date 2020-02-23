package com.varnaTravelGuideWeb.model;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
	
	 	private String imageURL;
	 	@Nullable
	    private Integer isMainImage;
	    
}
