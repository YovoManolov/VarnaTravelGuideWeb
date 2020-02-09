package com.varnaTravelGuideWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.service.impl.PlaceServiceImpl;

@RestController
@RequestMapping("/shoppingPlaces")
public class ShoppingPlaceController {

	@Autowired
	PlaceServiceImpl placeServiceImpl;

	@GetMapping("/getAll")
	public ResponseEntity<List<Place>> getAllShoppingPlaces() {
		List<Place> placeList = placeServiceImpl.getAllPlaces();
		return new ResponseEntity<List<Place>>(placeList, HttpStatus.OK);
	}

	@GetMapping("/getOneById/{id}")
	public ResponseEntity<Place> getShoppingPlaceById(@PathVariable(value = "id") String shoppingPlaceId)
			throws RecordNotFoundException {
		Place place = placeServiceImpl.getPlaceById(shoppingPlaceId);
		return new ResponseEntity<Place>(place, HttpStatus.OK);
	}

	@PutMapping("/create")
	public ResponseEntity<Place> createShoppingPlace(@RequestBody Place shoppingPlace) {

		Place createdShoppingPlace = placeServiceImpl.createPlace(shoppingPlace);
		return new ResponseEntity<Place>(createdShoppingPlace, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Place> updatePlace(@RequestBody Place newShoppingPlace, @PathVariable String shoppingPlaceId)
			throws RecordNotFoundException {

		Place updatedShoppingPlace = placeServiceImpl.updatePlace(newShoppingPlace, shoppingPlaceId);
		return new ResponseEntity<Place>(updatedShoppingPlace, HttpStatus.OK);

	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Object> deletePeriferialDeviceById(@PathVariable("id") String soppingPlaceId)
			throws RecordNotFoundException {
		return placeServiceImpl.deletePlaceById(soppingPlaceId);
	}
}
