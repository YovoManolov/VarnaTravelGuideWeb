package com.varnaTravelGuideWeb.service.intrf;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;

public interface PriceCategoryServiceI {
	
	public String getPriceCategoryDescrByPlaceId(String placeId) throws RecordNotFoundException;
	public String addNewPlaceIdByPriceCategoryDescr(String priceCategoryDescr, Place place);
	public String deletePlaceFromPCByPlaceId(String placeId) throws RecordNotFoundException;
}
