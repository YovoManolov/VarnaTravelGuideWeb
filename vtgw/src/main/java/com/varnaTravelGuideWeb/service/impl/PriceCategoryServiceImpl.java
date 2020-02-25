package com.varnaTravelGuideWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.PriceCategory;
import com.varnaTravelGuideWeb.repository.PriceCategoryRepository;
import com.varnaTravelGuideWeb.service.intrf.PriceCategoryServiceI;

@Service
public class PriceCategoryServiceImpl implements PriceCategoryServiceI {
	
	@Autowired
	PriceCategoryRepository priceCategoryRepository;

	@Override
	public String getPriceCategoryDescrByPlaceId(String placeId) throws RecordNotFoundException{
		
		List<PriceCategory> pcList = priceCategoryRepository.findAll();
		
		PriceCategory priceCategory  = pcList.stream().filter(
					pc -> pc.getPlaces().stream().anyMatch(
								place-> ( place.get_id().compareTo(placeId) == 0 )
					) 
			).findFirst().orElse(null);
		
		if(priceCategory == null) {
			throw new RecordNotFoundException("PriceCategory not found for place with id: " + placeId + " !" );
		}else {
			return priceCategory.getDescription();
		}
	}

}
