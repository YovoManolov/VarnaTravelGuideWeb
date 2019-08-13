package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class PriceCategory {
		
		@Id
		@Field("_id")
	 	private String id;
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
	    
	    public Integer getPriceCategory_id() {
	        return priceCategory_id;
	    }

	    public String getId() {
			return id;
		}
	    
		public void setId(String id) {
			this.id = id;
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
