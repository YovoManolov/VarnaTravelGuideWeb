package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Document
@ToString
@Getter
@Setter
public class Hotel {
		
		@Id
	    private String _id ;
		@Field("place_id")
	    private String placeId;
	    private int numbOfStars;

	    public Hotel(String _id, String placeId, int numbOfStars) {
			super();
			this._id = _id;
			this.placeId = placeId;
			this.numbOfStars = numbOfStars;
		}
	    
		public Hotel(String placeId, int numbOfStars) {
			super();
			this.placeId = placeId;
			this.numbOfStars = numbOfStars;
		}

}
