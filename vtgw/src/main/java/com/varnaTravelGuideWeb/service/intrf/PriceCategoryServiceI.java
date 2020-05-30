package com.varnaTravelGuideWeb.service.intrf;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;

public interface PriceCategoryServiceI {
	
	public String getPriceCategoryDescrByPlaceId(String placeId) throws RecordNotFoundException;
	public String addNewPlaceIdByPriceCategoryDescr(String priceCategoryDescr, String placeId);
	public String deletePlaceFromPCByPlaceId(String placeId) throws RecordNotFoundException;
}
