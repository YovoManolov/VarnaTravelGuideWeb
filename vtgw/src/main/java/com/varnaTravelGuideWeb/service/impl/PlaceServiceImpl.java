package com.varnaTravelGuideWeb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.exception.RecordsNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.repository.PlaceRepository;
import com.varnaTravelGuideWeb.service.intrf.PlaceServiceI;

@Service
public class PlaceServiceImpl implements PlaceServiceI {

	@Autowired
	PlaceRepository placeRepository;

	@Override
	public List<Place> getAllPlaces() throws RecordsNotFoundException {

		List<Place> placesList = placeRepository.findAll();

		if (placesList.size() > 0) {
			return placesList;
		} else {
			throw new RecordsNotFoundException("Places not retrieved from DB! ");
		}
	}

	@Override
	public Place getPlaceById(String placeId) throws RecordNotFoundException {

		Optional<Place> place = placeRepository.findById(placeId);

		if (place.isPresent()) {
			return place.get();
		} else {
			throw new RecordNotFoundException("No place record exist for given placeId");
		}
	}

	@Override
	public Place updatePlace(Place newPlace, Place currentPlace) {

			currentPlace.setAddress(newPlace.getAddress());
			currentPlace.setContacts(newPlace.getContacts());
			currentPlace.setDescription(newPlace.getDescription());
			currentPlace.setImages(newPlace.getImages());
			currentPlace.setLocation(newPlace.getLocation());
			currentPlace.setName(newPlace.getName());
			currentPlace.setPriceCategory(newPlace.getPriceCategory());
			currentPlace.setTypeOfPlace(newPlace.getTypeOfPlace());
			currentPlace.setWorkHours(newPlace.getWorkHours());

			return placeRepository.save(currentPlace);
	}

	@Override
	public Place createPlace(Place newPlace) {
		return placeRepository.save(newPlace);
	}

	@Override
	public ResponseEntity<String> deletePlaceById(String placeId) throws RecordNotFoundException {

		Optional<Place> place = placeRepository.findById(placeId);

		if (place.isPresent()) {
			placeRepository.deleteById(placeId);
		} else {
			throw new RecordNotFoundException("No place record exist for given id:: " + placeId);
		}

		return new ResponseEntity<String>("Place deleted", HttpStatus.OK);

	}

	
}
