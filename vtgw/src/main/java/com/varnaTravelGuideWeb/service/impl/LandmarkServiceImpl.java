package com.varnaTravelGuideWeb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Landmark;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.repository.LandmarkRepository;
import com.varnaTravelGuideWeb.service.intrf.LandmarkServiceI;

public class LandmarkServiceImpl implements LandmarkServiceI {

	@Autowired 
	LandmarkRepository landmarkRepository;
	
	@Autowired 
	PlaceServiceImpl placeServiceImpl;
	
	@Override
	public List<Landmark> getAllLandmarks() {
		
		List<Landmark> landmarkList = landmarkRepository.findAll();
		
        if(landmarkList.size() > 0) {
            return landmarkList;
        } else {
            return new ArrayList<Landmark>();
        }
	}
	
	@Override
	public Landmark getLandmarkById(String landmarkId) throws RecordNotFoundException {
		
		Optional<Landmark> landmark =  landmarkRepository.findById(landmarkId);
	    
	    if(landmark.isPresent()) {
            return landmark.get();
        } else {
            throw new RecordNotFoundException("No landmark record exist for given landmarkId");
        }
	}

	@Override
	public Landmark updateLandmark(Landmark newLandmark, Place newPlace, String landmarkId) {
		
		Optional<Landmark> updatedLandmark = landmarkRepository.findById(landmarkId).map(landmarkUpdated -> {
			
			landmarkUpdated.setEntranceTicket(newLandmark.getEntranceTicket());
			placeServiceImpl.updatePlace(newPlace, newLandmark.getPlaceId());

			return landmarkRepository.save(landmarkUpdated);
		});

		return (Landmark) updatedLandmark.get();
	}

	@Override
	public Landmark createLandmark(Landmark newLandmark,Place newPlace){
		
		 Place createdPlace = placeServiceImpl.createPlace(newPlace);
		 newLandmark.setPlaceId(createdPlace.getId());
		 
		 return landmarkRepository.save(newLandmark);
	}

	@Override
	public ResponseEntity<Object> deleteLandmark(String landmarkId) throws RecordNotFoundException {
		
		Optional<Landmark> periferialDevice = landmarkRepository
				.findById(landmarkId);
		
		if(periferialDevice.isPresent()) {
			landmarkRepository.deleteById(landmarkId);
		} else {
	        throw new RecordNotFoundException(
	            "Landmark record with id : " + landmarkId + " does not exist !"
	        );
	    }
		
		return ResponseEntity.ok().build();
	
	}

}
