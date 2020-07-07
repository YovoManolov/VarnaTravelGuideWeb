package com.varnaTravelGuideWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.exception.RecordsNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.service.impl.PlaceServiceImpl;

@RestController
@RequestMapping("/places")
public class PlaceController {

	@Autowired
	PlaceServiceImpl placeServiceImpl;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Place>> getAllPlaces() throws RecordsNotFoundException {
		List<Place> placeList = placeServiceImpl.getAllPlaces();
		return new ResponseEntity<List<Place>>(placeList, HttpStatus.OK);
	}

	@GetMapping("/getOneById/{id}")
	public ResponseEntity<Place> getHotelById(@PathVariable(value = "id") String placeId)
			throws RecordNotFoundException {
		Place place = placeServiceImpl.getPlaceById(placeId);
		return new ResponseEntity<Place>(place, HttpStatus.OK);
	}
}
