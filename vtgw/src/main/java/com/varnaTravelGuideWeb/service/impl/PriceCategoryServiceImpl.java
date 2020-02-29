package com.varnaTravelGuideWeb.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
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

	@Override
	public String addNewPlaceIdByPriceCategoryDescr(String priceCategoryDescr, Place place) 
						throws NoSuchElementException {
		
		PriceCategory priceCat = priceCategoryRepository.findAll().stream().filter
				( pc -> 0 == pc.getDescription().compareTo(priceCategoryDescr)).findFirst().get(); 
		
		if(priceCat.getPlaces().add(place)) {
			priceCategoryRepository.save(priceCat);
			return "Place with id: " + place.get_id() + "Aded to price category with " +
					 "description: "  +  priceCategoryDescr + "!";
		}else {
			return "Problem has occured while adding place id to price category document!";
		}
	}

}
