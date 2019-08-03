package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PriceCategory {
		
		@Id
	 	private String _id;
	    private Integer priceCategory_id ;
	    private String description;

	    public PriceCategory(){}
	    public PriceCategory(String description) {
	        this.description = description;
	    }

		/*
		 * public PriceCategory(Document document) { _id = document.getString("_id");
		 * priceCategory_id = document.getInteger("priceCategory_id"); description =
		 * document.getString("description"); }
		 */

	    public String get_id() {
	        return _id;
	    }

	    public void set_id(String _id) {
	        this._id = _id;
	    }

	    public Integer getPriceCategory_id() {
	        return priceCategory_id;
	    }

	    public void setPriceCategory_id(Integer priceCategory_id) {
	        this.priceCategory_id = priceCategory_id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public static PriceCategory[] populatePriceCategories() {
	        return new PriceCategory[]{
	                new PriceCategory("BUDGET"),
	                new PriceCategory("MID_RANGE"),
	                new PriceCategory("PREMIUM"),
	                new PriceCategory("COMBINED")
	        };
	    }
}