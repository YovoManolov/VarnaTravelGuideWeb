package com.varnaTravelGuideWeb.service.intrf;

import org.springframework.web.bind.annotation.PathVariable;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.PriceCategory;

public interface PriceCategoryServiceI {
	
	public PriceCategory getPriceCategoryByPlaceId(@PathVariable(value = "id") String placeId) throws RecordNotFoundException;
}
