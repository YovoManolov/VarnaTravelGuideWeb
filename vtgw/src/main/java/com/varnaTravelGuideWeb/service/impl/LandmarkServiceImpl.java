package com.varnaTravelGuideWeb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
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
        	
        	for(Landmark landmark : landmarkList) {
       		   try {
       				Place p = placeServiceImpl.getPlaceById(landmark.getPlace_id().toHexString());
       				landmark.setPlace(p);
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
	    	Place p = placeServiceImpl.getPlaceById(landmarkObj.getPlace_id().toHexString());
	    	landmarkObj.setPlace(p);
	    	
	    	return landmarkObj;
        } else {
            throw new RecordNotFoundException("No landmark record exist for given landmarkId: "+ landmarkId);
        }
	
	}

	@Override
	public Landmark updateLandmark(Landmark newLandmark, String landmarkId) {
		
		Optional<Landmark> updatedLandmark = landmarkRepository.findById(landmarkId).map(landmarkUpdated -> {
			
			if(landmarkUpdated.getEntranceTicket() !=  newLandmark.getEntranceTicket()) {
				landmarkUpdated.setEntranceTicket(newLandmark.getEntranceTicket());
			}
			
			Place currentLandmarkPlace = null;
			try {
				currentLandmarkPlace = placeServiceImpl.getPlaceById(newLandmark.getPlace().get_id());
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}
			placeServiceImpl.updatePlace(newLandmark.getPlace(),currentLandmarkPlace);

			return landmarkRepository.save(landmarkUpdated);
		});

		return (Landmark) updatedLandmark.get();
	}

	@Override
	public Landmark createLandmark(Landmark newLandmark){
		
		 if(newLandmark.get_id() == null || newLandmark.get_id().isEmpty()) {
			 newLandmark.set_id(new ObjectId().toString());
		 }
		 
		 Place newPlace = newLandmark.getPlace();
		 Place createdPlace = placeServiceImpl.createPlace(newPlace);
		 newLandmark.setPlace(createdPlace);
		 newLandmark.setPlace_id(new ObjectId(createdPlace.get_id()));
		 
		 return landmarkRepository.save(newLandmark);
	}

	@Override
	public ResponseEntity<Object> deleteLandmark(String landmarkId) throws RecordNotFoundException {
		
		Optional<Landmark> landmarkOptional = landmarkRepository
				.findById(landmarkId);
		
		if(landmarkOptional.isPresent()) {
			Place landmarkPlace = placeServiceImpl.getPlaceById(
					landmarkOptional.get().getPlace_id().toHexString()
			);
		
			placeServiceImpl.deletePlaceById(landmarkPlace.get_id());
			
			landmarkRepository.deleteById(landmarkId);
		} else {
	        throw new RecordNotFoundException(
	            "Landmark record with id : " + landmarkId + " does not exist !"
	        );
	    }
		
		return ResponseEntity.ok().build();
	
	}

}
