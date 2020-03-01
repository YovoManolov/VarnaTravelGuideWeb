package com.varnaTravelGuideWeb.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.exception.RecordsNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.repository.PlaceRepository;
import com.varnaTravelGuideWeb.service.intrf.PlaceServiceI;

@Service
public class PlaceServiceImpl implements PlaceServiceI {

	@Autowired
	PlaceRepository placeRepository;
	
	@Autowired 
	PriceCategoryServiceImpl priceCategorySerciceImpl;

	@Override
	public List<Place> getAllPlaces() throws RecordsNotFoundException {

		List<Place> placesList = placeRepository.findAll();
		for(Place place : placesList) {
			try {
				place.setPriceCategoryDescription(priceCategorySerciceImpl
							.getPriceCategoryDescrByPlaceId(place.get_id()));
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		if (placesList.size() > 0) {
			return placesList;
		} else {
			throw new RecordsNotFoundException("Places not retrieved from DB! ");
		}
	}

	@Override
	public Place getPlaceById(String placeId) throws RecordNotFoundException {

		Optional<Place> place = placeRepository.findById(placeId);
		
		if (place.isPresent()) {
			Place p = place.get();
			p.setPriceCategoryDescription(priceCategorySerciceImpl
						.getPriceCategoryDescrByPlaceId(p.get_id()));
			return p;
		} else {
			throw new RecordNotFoundException("No place record exist for given placeId");
		}
		
	}

	@Override
	public Place updatePlace(Place newPlace, Place currentPlace) {
            
			//currently price category description update is not implemented ! 
		
			if(currentPlace.getName().compareToIgnoreCase(newPlace.getName().trim()) != 0 ) {
		    	currentPlace.setName(newPlace.getName());
		    }
		    
		    if(currentPlace.getAddress().compareToIgnoreCase(newPlace.getAddress().trim()) != 0 ) {
		    	currentPlace.setAddress(newPlace.getAddress());
		    }
		    
		    if(currentPlace.getLocation().equals(newPlace.getLocation()) == false ) {
		    	currentPlace.setLocation(newPlace.getLocation());
		    }
		    
		    if(currentPlace.getContacts().compareToIgnoreCase(newPlace.getContacts().trim()) != 0 ) {
		    	currentPlace.setContacts(newPlace.getContacts());
		    }
		    
		    if(currentPlace.getDescription().compareToIgnoreCase(newPlace.getDescription().trim()) != 0 ) {
		    	currentPlace.setDescription(newPlace.getDescription());
		    }
		    
		    if(currentPlace.getTypeOfPlace() != newPlace.getTypeOfPlace()) {
		    	currentPlace.setTypeOfPlace(newPlace.getTypeOfPlace());
		    }
		    
		    if(currentPlace.getAddress().compareToIgnoreCase(newPlace.getAddress().trim()) != 0 ) {
		    	currentPlace.setAddress(newPlace.getAddress());
		    }
		    
		    if(!currentPlace.getWorkHours().equals(newPlace.getWorkHours())) {
		    	currentPlace.setWorkHours(newPlace.getWorkHours());
		    }
		    
			return placeRepository.save(currentPlace);
	}

	@Override
	public Place createPlace(Place newPlace) {
		
		if(newPlace.get_id() == null || newPlace.get_id().isEmpty()) {
			newPlace.set_id(new ObjectId().toString());
		}
		
		priceCategorySerciceImpl.addNewPlaceIdByPriceCategoryDescr(
					newPlace.getPriceCategoryDescription(),newPlace);
		
		return placeRepository.save(newPlace);
	}

	@Override
	public ResponseEntity<String> deletePlaceById(String placeId) throws RecordNotFoundException {
			
		Optional<Place> place = placeRepository.findById(placeId);
				
		if (place.isPresent()) {
			priceCategorySerciceImpl.deletePlaceFromPCByPlaceId(placeId);
			placeRepository.deleteById(placeId);
		} else {
			throw new RecordNotFoundException("No place record exist for given id:: " + placeId);
		}

		return new ResponseEntity<String>("Place deleted", HttpStatus.OK);

	}

	
}
