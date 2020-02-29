package com.varnaTravelGuideWeb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Hotel;
import com.varnaTravelGuideWeb.model.Landmark;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.repository.LandmarkRepository;
import com.varnaTravelGuideWeb.service.intrf.LandmarkServiceI;

@Service
public class LandmarkServiceImpl implements LandmarkServiceI {

	@Autowired 
	LandmarkRepository landmarkRepository;
	
	@Autowired 
	PlaceServiceImpl placeServiceImpl;
	
	@Override
	public List<Landmark> getAllLandmarks() {
		
		List<Landmark> landmarkList = landmarkRepository.findAll();
		
        if(landmarkList.size() > 0) {
        	
        	for(Landmark l : landmarkList) {
       		   try {
       				Place p = placeServiceImpl.getPlaceById(l.getPlace_id());
       				l.setPlace(p);
       			} catch (RecordNotFoundException e) {
       				e.printStackTrace();
       			}
       		}
        	
            return landmarkList;
        } else {
            return new ArrayList<Landmark>();
        }
        
	}
	
	@Override
	public Landmark getLandmarkById(String landmarkId) throws RecordNotFoundException {
		
		Optional<Landmark> landmark =  landmarkRepository.findById(landmarkId);
		
		if(landmark.isPresent()) {
	    	Landmark landmarkObj =  landmark.get();
	    	Place p = placeServiceImpl.getPlaceById(landmarkObj.getPlace_id());
	    	landmarkObj.setPlace(p);
	    	return landmarkObj;
        } else {
            throw new RecordNotFoundException("No landmark record exist for given landmarkId");
        }
	
	}

	@Override
	public Landmark updateLandmark(Landmark newLandmark, Place newPlace, String landmarkId) {
		
		Optional<Landmark> updatedLandmark = landmarkRepository.findById(landmarkId).map(landmarkUpdated -> {
			
			if(landmarkUpdated.getEntranceTicket() !=  newLandmark.getEntranceTicket()) {
				landmarkUpdated.setEntranceTicket(newLandmark.getEntranceTicket());
			}
			
			placeServiceImpl.updatePlace(newPlace, newLandmark.getPlace());

			return landmarkRepository.save(landmarkUpdated);
		});

		return (Landmark) updatedLandmark.get();
	}

	@Override
	public Landmark createLandmark(Landmark newLandmark,Place newPlace){
		
		 Place createdPlace = placeServiceImpl.createPlace(newPlace);
		 newLandmark.setPlace(createdPlace);
		 
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
