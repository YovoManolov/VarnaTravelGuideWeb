package com.varnaTravelGuideWeb.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.varnaTravelGuideWeb.exception.NotAShoppingPlaceException;
import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.exception.RecordsNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.service.impl.PlaceServiceImpl;

@RestController
@RequestMapping("/shoppingPlaces")
public class ShoppingPlaceController {

	@Autowired
	PlaceServiceImpl placeServiceImpl;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Place>> getAllShoppingPlaces() throws RecordsNotFoundException {
		
		List<Place> shoppingPlacesList = placeServiceImpl.getAllPlaces().stream()
					.filter(place -> place.getTypeOfPlace() == 3 ).collect(Collectors.toList());
		return new ResponseEntity<List<Place>>(shoppingPlacesList, HttpStatus.OK);
	}		

	@GetMapping("/getShoppingPlaceById/{id}")
	public ResponseEntity<Place> getShoppingPlaceById(@PathVariable(value = "id") String shoppingPlaceId)
			throws NotAShoppingPlaceException, RecordNotFoundException {
		Place place = placeServiceImpl.getPlaceById(shoppingPlaceId);
		if(place.getTypeOfPlace() != 3) {
			throw new NotAShoppingPlaceException("The place retrieved is not a shopping place! ");
		}else {
			return new ResponseEntity<Place>(place, HttpStatus.OK);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Place> createShoppingPlace(@RequestBody Place shoppingPlace) {
		Place createdShoppingPlace = placeServiceImpl.createPlace(shoppingPlace);
		return new ResponseEntity<Place>(createdShoppingPlace, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Place> updatePlace(@RequestBody Place newShoppingPlace, @PathVariable String shoppingPlaceId)
			throws RecordNotFoundException {
		
		Place currentShoppingPlace = placeServiceImpl.getPlaceById(shoppingPlaceId);
		Place updatedShoppingPlace = placeServiceImpl.updatePlace(newShoppingPlace, currentShoppingPlace);
		
		return new ResponseEntity<Place>(updatedShoppingPlace, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deletePeriferialDeviceById(@PathVariable("id") String soppingPlaceId)
			throws RecordNotFoundException {
		return placeServiceImpl.deletePlaceById(soppingPlaceId);
	}
}
