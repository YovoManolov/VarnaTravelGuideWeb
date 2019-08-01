package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel {
		
		@Id
	    private String _id ;
	    private String place_id;
	    private int numbOfStars;

	    public Hotel(String _id, String place_id, int numbOfStars) {
			super();
			this._id = _id;
			this.place_id = place_id;
			this.numbOfStars = numbOfStars;
		}
	    
		public Hotel(String place_id, int numbOfStars) {
			super();
			this.place_id = place_id;
			this.numbOfStars = numbOfStars;
		}


	    @Override
	    public String toString() {
	        return "Hotel{" +
	                "_id=" + _id +
	                ", place_id=" + place_id +
	                ", numbOfStars=" + numbOfStars +
	                '}';
	    }

	    public String getId() {
	        return _id;
	    }

	    public void setId(String id) {
	        this._id = id;
	    }

	    public String getplace_id() {
	        return place_id;
	    }

	    public void setplace_id(String place_id) {
	        this.place_id = place_id;
	    }

	    public int getNumbOfStars() {
	        return numbOfStars;
	    }

	    public void setNumbOfStars(int numbOfStars) {
	        this.numbOfStars = numbOfStars;
	    }

}
