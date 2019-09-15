package com.varnaTravelGuideWeb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

		/*
		 * public Landmark(final Document document) { _id = document.getString("_id");
		 * placeId = document.getString("placeId"); entranceTicket =
		 * document.getString("entranceTicket"); }
		 */

	    public String get_id() {
	        return _id;
	    }

	    public void set_id(String _id) {
	        this._id = _id;
	    }

	    public String getPlaceId() {
	        return placeId;
	    }

	    public void setPlaceId(String placeId) {
	        this.placeId = placeId;
	    }

	    public String getEntranceTicket() {
	        return entranceTicket;
	    }

	    public void setEntranceTicket(String entranceTicket) {
	        this.entranceTicket = entranceTicket;
	    }

	/*   public static Landmark[] populateLandmarks() {
	        return new Landmark[] {
	               new Landmark(16,"Adults: 3.00 leva\n" +
	                                                 " Children/Students: 2.00 leva" ),
	                new Landmark(17,"Information not available. " ),
	                new Landmark(18,"No ticket required "),
	                new Landmark(19,
	                        "Adults: 4.00 leva\n" +
	                                "Students: 1.00 leva\n"+
	                                "Organized groups: 0.50 leva \n"+
	                                "Lecture: 4.00 leva"),
	                new Landmark(20,"Adults:  10.00  leva\n" +
	                                                     "Children/Students: 2.00 leva")
	        };
	    }*/

}
