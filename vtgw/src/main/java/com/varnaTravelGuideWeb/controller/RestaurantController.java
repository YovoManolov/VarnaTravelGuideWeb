package com.varnaTravelGuideWeb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RestaurantController {
	public List<Restaurant> getAllResaturants() throws InterruptedException;
    public Restaurant getRestaurantByPlaceId(ObjectId place_id);
    
    public addNewRestaurant(RequestBody Restaurant restaurant);
}
