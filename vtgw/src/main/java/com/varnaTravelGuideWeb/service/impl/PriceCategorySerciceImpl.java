package com.varnaTravelGuideWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.PriceCategory;
import com.varnaTravelGuideWeb.repository.PriceCategoryRepository;
import com.varnaTravelGuideWeb.service.intrf.PriceCategoryServiceI;

public class PriceCategorySerciceImpl implements PriceCategoryServiceI {
	
	@Autowired
	PriceCategoryRepository priceCategoryRepository;

	@Override
	public PriceCategory getPriceCategoryByPlaceId(String placeId) throws RecordNotFoundException {
		
		List<PriceCategory> pcList = priceCategoryRepository.findAll();
		
		PriceCategory priceCategory  = pcList.stream().filter(
					pc -> pc.getPlaces().stream().anyMatch(
								place-> ( place.get_id().compareTo(placeId) == 0 )
					) 
			).findFirst().orElse(null);
		
		if(priceCategory == null) {
			throw new RecordNotFoundException("PriceCategory not found for place with id: " + placeId + " !" );
		}else {
			return priceCategory;
		}
		
	}

}
