package com.varnaTravelGuideWeb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.Restaurant;
import com.varnaTravelGuideWeb.repository.RestaurantRepository;
import com.varnaTravelGuideWeb.service.intrf.RestaurantServiceI;

public class RestaurantServiceImpl implements RestaurantServiceI {

	@Autowired 
	RestaurantRepository restaurantRepository;
	
	@Autowired 
	PlaceServiceImpl placeServiceImpl;
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		
		List<Restaurant> restaurantsList = restaurantRepository.findAll();
		
        if(restaurantsList.size() > 0) {
            return restaurantsList;
        } else {
            return new ArrayList<Restaurant>();
        }
	}
	
	@Override
	public Restaurant getRestaurantById(String restaurantId) throws RecordNotFoundException {
		
		Optional<Restaurant> restaurant =  restaurantRepository.findById(restaurantId);
	    
	    if(restaurant.isPresent()) {
            return restaurant.get();
        } else {
            throw new RecordNotFoundException("No restaurant record exist for given restaurantId");
        }
	}

	@Override
	public Restaurant updateRestaurant(Restaurant newRestaurant, Place newPlace, String restaurantId) {
		
		Optional<Restaurant> updatedRestaurant = restaurantRepository.findById(restaurantId).map(restaurantUpdated -> {
			
			restaurantUpdated.setCuisine(newRestaurant.getCuisine());
			placeServiceImpl.updatePlace(newPlace, newRestaurant.getPlaceId());

			return restaurantRepository.save(restaurantUpdated);
		});

		return (Restaurant) updatedRestaurant.get();
	}

	@Override
	public Restaurant createRestaurant(Restaurant newRestaurant, Place newPlace){
		
		 Place createdPlace = placeServiceImpl.createPlace(newPlace);
		 newRestaurant.setPlaceId(createdPlace.getId());
		 
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
