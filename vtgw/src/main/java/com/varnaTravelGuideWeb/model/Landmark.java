package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Landmark {

		@Id
	    private String _id ;
		@Field("place_id")
	    private String placeId;
	    private String entranceTicket;

	    public Landmark(String _id , String placeId, String entranceTicket) {
	        this._id = _id;
	        this.placeId = placeId;
	        this.entranceTicket = entranceTicket;
	    }

	    public Landmark(String placeId, String entranceTicket) {
	        this.placeId = placeId;
	        this.entranceTicket = entranceTicket;
	    }

	
}
