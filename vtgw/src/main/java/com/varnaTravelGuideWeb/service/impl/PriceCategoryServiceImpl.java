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
	public String addNewPlaceIdByPriceCategoryDescr(String priceCategoryDescr, String placeId) 
						throws NoSuchElementException {
		
		PriceCategory priceCat = priceCategoryRepository.findAll().stream().filter
				( pc -> 0 == pc.getDescription().compareTo(priceCategoryDescr)).findFirst().get(); 
		
		Place placeToRemoveFromPriceCategory = new Place();
		placeToRemoveFromPriceCategory.set_id(placeId);
		
		if(priceCat.getPlaces().add(placeToRemoveFromPriceCategory)) {
			priceCategoryRepository.save(priceCat);
			return "Place with id: " + placeToRemoveFromPriceCategory.get_id() + "Aded to price category with " +
					 "description: "  +  priceCategoryDescr + "!";
		}else {
			return "Problem has occured while adding place id to price category document!";
		}
	}

	@Override
	public String deletePlaceFromPCByPlaceId(String placeId) throws RecordNotFoundException {
		
		List<PriceCategory> pcList = priceCategoryRepository.findAll();
		
		PriceCategory priceCategory  = pcList.stream().filter(
					pc -> pc.getPlaces().stream().anyMatch(
								place-> ( place.get_id().compareTo(placeId) == 0 )
					) 
		).findFirst().orElse(null);
		
		if(priceCategory != null) {
			
				List<Place> listOfPlacesForSpecificCategory = priceCategory.getPlaces();
			
				int indexToDelete;
				Place deletedPlaceFromPC = null;
				for(Place p : listOfPlacesForSpecificCategory) {
					if(p.get_id().compareTo(placeId) == 0) {
						indexToDelete = listOfPlacesForSpecificCategory.indexOf(p);
						deletedPlaceFromPC = listOfPlacesForSpecificCategory.remove(indexToDelete);
						priceCategory.setPlaces(listOfPlacesForSpecificCategory);
						break;
					}
				}
				
				priceCategoryRepository.save(priceCategory);
				
				if(deletedPlaceFromPC == null) {
					throw new RecordNotFoundException("Place with id " + placeId 
					+" was not found in priceCategory :" + priceCategory.getDescription() +" !" );
				}else {
					return "Place with id " + deletedPlaceFromPC.get_id() +" was deleted "
							+ "from priceCategory :" + priceCategory.getDescription() ;
				}
				
		}else {
			throw new RecordNotFoundException("PriceCategory not found witch contains place with id: " + placeId);
		}
	}

}
