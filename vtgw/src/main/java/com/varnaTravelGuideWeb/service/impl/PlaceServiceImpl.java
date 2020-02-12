package com.varnaTravelGuideWeb.service.impl;

import java.util.ArrayList;
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
	public Place updatePlace(Place newPlace, String placeId) {

		Optional<Place> updatedPlace = placeRepository.findById(placeId).map(placeUpdated -> {

			placeUpdated.setAddress(newPlace.getAddress());
			placeUpdated.setContacts(newPlace.getContacts());
			placeUpdated.setDescription(newPlace.getDescription());
			placeUpdated.setImages(newPlace.getImages());
			placeUpdated.setLatitude(newPlace.getLatitude());
			placeUpdated.setLongitude(newPlace.getLongitude());
			placeUpdated.setName(newPlace.getName());
			placeUpdated.setPriceCategoryId(newPlace.getPriceCategoryId());
			placeUpdated.setTypeOfPlace(newPlace.getTypeOfPlace());
			placeUpdated.setWorkHours(newPlace.getWorkHours());

			return placeRepository.save(placeUpdated);
		});

		return (Place) updatedPlace.get();
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
