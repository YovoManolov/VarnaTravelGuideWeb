package com.varnaTravelGuideWeb.dao;

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
public class HotelDAO {
		
		@Id
	    private String _id ;
		@Field("place_id")
	    private String placeId;
	    private int numbOfStars;

	    public HotelDAO(String _id, String placeId, int numbOfStars) {
			super();
			this._id = _id;
			this.placeId = placeId;
			this.numbOfStars = numbOfStars;
		}
	    
		public HotelDAO(String placeId, int numbOfStars) {
			super();
			this.placeId = placeId;
			this.numbOfStars = numbOfStars;
		}

}
