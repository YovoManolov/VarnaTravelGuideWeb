package com.varnaTravelGuideWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.Restaurant;
import com.varnaTravelGuideWeb.service.impl.RestaurantServiceImpl;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantServiceImpl restaurantServiceImpl;

	@GetMapping("/getAll")
	public ResponseEntity<List<Restaurant>> getAllRestaurants() {
		List<Restaurant> placeList = restaurantServiceImpl.getAllRestaurants();
		return new ResponseEntity<List<Restaurant>>(placeList, HttpStatus.OK);
	}

	@GetMapping("/getOneById/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(value = "id") String restaurantId)
			throws RecordNotFoundException {
		Restaurant place = restaurantServiceImpl.getRestaurantById(restaurantId);
		return new ResponseEntity<Restaurant>(place, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant, @RequestBody Place place) {

		Restaurant createdRestaurant = restaurantServiceImpl.createRestaurant(restaurant, place);
		return new ResponseEntity<Restaurant>(createdRestaurant, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant newRestaurant,
					@RequestBody Place newPlace, @PathVariable(value = "id") String restaurantId) throws RecordNotFoundException {

		Restaurant updatedShoppingRestaurant = restaurantServiceImpl.updateRestaurant(newRestaurant, newPlace ,restaurantId);
		return new ResponseEntity<Restaurant>(updatedShoppingRestaurant, HttpStatus.OK);

	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Object> deletePeriferialDeviceById(@PathVariable("id") String restaurantId)
			throws RecordNotFoundException {
		
		return restaurantServiceImpl.deleteRestaurant(restaurantId);
	}
}
