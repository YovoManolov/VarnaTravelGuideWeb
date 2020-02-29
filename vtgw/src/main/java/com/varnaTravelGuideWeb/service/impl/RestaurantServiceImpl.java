package com.varnaTravelGuideWeb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Landmark;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.Restaurant;
import com.varnaTravelGuideWeb.repository.RestaurantRepository;
import com.varnaTravelGuideWeb.service.intrf.RestaurantServiceI;

@Service
public class RestaurantServiceImpl implements RestaurantServiceI {

	@Autowired 
	RestaurantRepository restaurantRepository;
	
	@Autowired 
	PlaceServiceImpl placeServiceImpl;
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		
		List<Restaurant> restaurantsList = restaurantRepository.findAll();
		
        if(restaurantsList.size() > 0) {
        	
        	for(Restaurant r : restaurantsList) {
 	 		   try {
 	 				Place p = placeServiceImpl.getPlaceById(r.getPlace_id());
 	 				r.setPlace(p);
 	 			} catch (RecordNotFoundException e) {
 	 				e.printStackTrace();
 	 			}
        	}
        	
            return restaurantsList;
        } else {
            return new ArrayList<Restaurant>();
        }
	}
	
	@Override
	public Restaurant getRestaurantById(String restaurantId) throws RecordNotFoundException {
		
		Optional<Restaurant> restaurant =  restaurantRepository.findById(restaurantId);
	    
		if(restaurant.isPresent()) {
			Restaurant restaurantObj =  restaurant.get();
	    	Place p = placeServiceImpl.getPlaceById(restaurantObj.getPlace_id());
	    	restaurantObj.setPlace(p);
	    	return restaurantObj;
        } else {
        	 throw new RecordNotFoundException("No restaurant record exist for given restaurantId");
        }
	}

	@Override
	public Restaurant updateRestaurant(Restaurant newRestaurant, String restaurantId) {
		
		Optional<Restaurant> updatedRestaurant = restaurantRepository.findById(restaurantId)
										.map(restaurantUpdated -> {
			
			if(restaurantUpdated.getCuisine().compareTo(newRestaurant.getCuisine()) != 0) {
				restaurantUpdated.setCuisine(newRestaurant.getCuisine());
			}	
			
			Place currentRestaurantPlace = null;
			try {
				currentRestaurantPlace = placeServiceImpl.getPlaceById(newRestaurant.getPlace().get_id());
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}
			
			placeServiceImpl.updatePlace(newRestaurant.getPlace(),currentRestaurantPlace);
			return restaurantRepository.save(restaurantUpdated);
		});

		return (Restaurant) updatedRestaurant.get();
	}

	@Override
	public Restaurant createRestaurant(Restaurant newRestaurant, Place newPlace){
		
		 Place createdPlace = placeServiceImpl.createPlace(newPlace);
		 newRestaurant.setPlace(createdPlace);
		 
		 return restaurantRepository.save(newRestaurant);
	}

	@Override
	public ResponseEntity<Object> deleteRestaurant(String restaurantId) throws RecordNotFoundException {
		
		Optional<Restaurant> periferialDevice = restaurantRepository
				.findById(restaurantId);
		
		if(periferialDevice.isPresent()) {
			restaurantRepository.deleteById(restaurantId);
		} else {
	        throw new RecordNotFoundException(
	            "Restaurant record with id : " + restaurantId + " does not exist !"
	        );
	    }
		
		return ResponseEntity.ok().build();
	}

}
