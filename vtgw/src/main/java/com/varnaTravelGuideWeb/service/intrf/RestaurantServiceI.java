package com.varnaTravelGuideWeb.service.intrf;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.Restaurant;

public interface RestaurantServiceI {
	
	public List<Restaurant> getAllRestaurants();

	public Restaurant getRestaurantById(@PathVariable(value = "id") String restaurantId) throws RecordNotFoundException;

	public Restaurant updateRestaurant(Restaurant newRestaurant, Place place, String restaurantId) throws RecordNotFoundException;

	public Restaurant createRestaurant(Restaurant newRestaurant, Place newPlace);

	public ResponseEntity<Object> deleteRestaurant(String restaurantId) throws RecordNotFoundException;
}
