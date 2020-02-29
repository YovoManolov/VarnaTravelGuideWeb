package com.varnaTravelGuideWeb.service.intrf;

import org.springframework.web.bind.annotation.PathVariable;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.PriceCategory;

public interface PriceCategoryServiceI {
	
	public String getPriceCategoryDescrByPlaceId(@PathVariable(value = "id") String placeId) throws RecordNotFoundException;
	public String addNewPlaceIdByPriceCategoryDescr(String priceCategoryDescr, Place place);
}
