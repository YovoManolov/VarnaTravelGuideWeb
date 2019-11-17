package com.varnaTravelGuideWeb.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import com.varnaTravelGuideWeb.dao.RestaurantDAO;
import com.varnaTravelGuideWeb.repository.RestaurantRepository;

@Controller
public class RestaurantController {
	
    private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantController(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	@RequestMapping(value = "/{placeId}", method = RequestMethod.GET)
	public RestaurantDAO getRestaurantByPlaceId(@PathVariable String placeId) {
		
		LOG.info("Getting restaurant with placeId: {}.", placeId);
		
		Optional<RestaurantDAO> optionalRestaurant = restaurantRepository.findByPlaceId(placeId);
		if(optionalRestaurant.isPresent()) {
		    // value is present inside Optional
			return optionalRestaurant.get();
		} else {
		    // value is absent
			LOG.warn("There is no user for this ID");
		}	
		return restaurantRepository.findByPlaceId(placeId).get();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<RestaurantDAO> getAllrestaurants(){
		LOG.info("Getting all restaurants.");
		return restaurantRepository.findAll();
	}

	public RestaurantDAO addNewRestaurant(@RequestBody RestaurantDAO restaurant){
		LOG.info("Saving restaurant.");
		return restaurantRepository.save(restaurant);
	}
	

}
