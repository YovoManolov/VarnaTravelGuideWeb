package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
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


	    @Override
	    public String toString() {
	        return "Hotel{" +
	                "_id=" + _id +
	                ", placeId=" + placeId +
	                ", numbOfStars=" + numbOfStars +
	                '}';
	    }

	    public String getId() {
	        return _id;
	    }

	    public void setId(String id) {
	        this._id = id;
	    }

	    public String getPlaceId() {
	        return placeId;
	    }

	    public void setPlaceId(String placeId) {
	        this.placeId = placeId;
	    }

	    public int getNumbOfStars() {
	        return numbOfStars;
	    }

	    public void setNumbOfStars(int numbOfStars) {
	        this.numbOfStars = numbOfStars;
	    }

}
