package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WorkHours {
		
		@Id
		private String _id;
	    private boolean is24h;
	    private String monFri;
	    private String sat;
	    private String sun;

	    public WorkHours(String _id,boolean is24h, String monFri,
	                     String sat, String sun) {
	        this._id = _id;
	        this.is24h = is24h;
	        this.monFri = monFri;
	        this.sat = sat;
	        this.sun = sun;
	    }

		/*
		 * public WorkHours(final Document document) { _id =
		 * document.getObjectId("_id"); is24h = document.getBoolean("is_24H"); monFri =
		 * document.getString("mond_fird"); sat = document.getString("sat"); sun =
		 * document.getString("sun"); }
		 */

	    public String getMonFri() {
	        return monFri;
	    }

	    public void setMonFri(String monFri) {
	        this.monFri = monFri;
	    }

	    public String getSat() {
	        return sat;
	    }

	    public void setSat(String sat) {
	        this.sat = sat;
	    }

	    public String getSun() {
	        return sun;
	    }

	    public void setSun(String sun) {
	        this.sun = sun;
	    }

	    public boolean isIs24h() {
	        return is24h;
	    }

	    public void setIs24h(boolean is24h) {
	        this.is24h = is24h;
	    }

	    @Override
	    public String toString() {
	        if(is24h == true){
	            return " 24 hours open";
	        }else{
	            return " Monday- Friday: " + monFri
	                    +"\n Saturday: " + sat
	                    +"\n Sun: " + sun;
	        }
	    }
}
