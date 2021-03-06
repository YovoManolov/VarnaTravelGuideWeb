package com.varnaTravelGuideWeb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Hotel;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.repository.HotelRepository;
import com.varnaTravelGuideWeb.service.intrf.HotelServiceI;

@Service
public class HotelServiceImpl implements HotelServiceI {

	@Autowired 
	HotelRepository hotelRepository;
	
	@Autowired 
	PlaceServiceImpl placeServiceImpl;
	
	@Autowired 
	PriceCategoryServiceImpl priceCategoryServiceImpl;
	
	@Override
	public List<Hotel> getAllHotels() {
		
		List<Hotel> hotelList = hotelRepository.findAll();
		
        if(hotelList.size() > 0) {
        	
        	for(Hotel h : hotelList) {
     		   try {
     				Place p = placeServiceImpl.getPlaceById(h.getPlace_id().toHexString());
     				h.setPlace(p);
     			} catch (RecordNotFoundException e) {
     				e.printStackTrace();
     			}
     		}
        	
            return hotelList;
        } else {
            return new ArrayList<Hotel>();
        }
	}
	
	@Override
	public Hotel getHotelById(String hotelId) throws RecordNotFoundException {
		
		Optional<Hotel> hotel =  hotelRepository.findById(hotelId);
		
	    if(hotel.isPresent()) {
	    	Hotel hotelObj =  hotel.get();
	    	Place p = placeServiceImpl.getPlaceById(hotelObj.getPlace_id().toString());
	    	hotelObj.setPlace(p);
	    	return hotelObj;
        } else {
            throw new RecordNotFoundException("No hotel record exist for given hotelId: " + hotelId);
        }
	}

	@Override
	public Hotel updateHotel(Hotel newHotel, String hotelId) {
		
		Optional<Hotel> updatedHotel = hotelRepository.findById(hotelId).map(hotelUpdated -> {
			
			if(hotelUpdated.getNumbOfStars() !=  newHotel.getNumbOfStars()) {
				hotelUpdated.setNumbOfStars(newHotel.getNumbOfStars());
			}
		
			Place currentHotelPlace = null;
			try {
				currentHotelPlace = placeServiceImpl.getPlaceById(hotelUpdated.getPlace_id().toHexString());
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}
			
			Place updatedPlace = placeServiceImpl.updatePlace(newHotel.getPlace(), currentHotelPlace);
			hotelUpdated.setPlace(updatedPlace);
			
			return hotelRepository.save(hotelUpdated);
		});

		return (Hotel) updatedHotel.get();
	}

	@Override
	public Hotel createHotel(Hotel newHotel){
		
		 if(newHotel.get_id() == null || newHotel.get_id().isEmpty()) {
			newHotel.set_id(new ObjectId().toString());
		 }
		
		 Place newPlace = newHotel.getPlace();
		 Place createdPlace = placeServiceImpl.createPlace(newPlace);
		 newHotel.setPlace_id(new ObjectId(createdPlace.get_id()));
		 
		 return hotelRepository.save(newHotel);
	}

	@Override
	public ResponseEntity<Object> deleteHotel(String hotelId) throws RecordNotFoundException {
		
		Optional<Hotel> hotelOptional = hotelRepository
				.findById(hotelId);

		if(hotelOptional.isPresent()) {
			
			String placeIdToDelete= new String(placeServiceImpl.getPlaceById(
						hotelOptional.get().getPlace_id().toHexString()
			).get_id());
			
			placeServiceImpl.deletePlaceById(placeIdToDelete);
			priceCategoryServiceImpl.deletePlaceFromPCByPlaceId(placeIdToDelete);
			hotelRepository.deleteById(hotelId);
			
		} else {
	        throw new RecordNotFoundException(
	            "Hotel record with id : " + hotelId + " does not exist !"
	        );
	    }
		
		return ResponseEntity.ok("Hotel is deleted");
	}
}
