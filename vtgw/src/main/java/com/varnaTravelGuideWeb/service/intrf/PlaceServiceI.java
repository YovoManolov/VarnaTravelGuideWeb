package com.varnaTravelGuideWeb.service.intrf;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;

public interface PlaceServiceI {

	public List<Place> getAllPlaces();

	public Place getPlaceById(@PathVariable(value = "id") String placeId) throws RecordNotFoundException;
	
	public Place updatePlace(Place newPlace, String id ) throws RecordNotFoundException;
		
	public Place createPlace(Place newPlace) throws RecordNotFoundException;

	public ResponseEntity<Object> deletePlaceById(String placeId) throws RecordNotFoundException;

}
