package com.varnaTravelGuideWeb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class PlaceController {
	public Place getPlaceById(ObjectId placeId) throws InterruptedException;
    public List<Place> getPlacesByTypeOfPlace(int typeOfPlace) throws InterruptedException;

	addNewPlace(RequestBody Place place);
}
