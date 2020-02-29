package com.varnaTravelGuideWeb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Override
	public List<Hotel> getAllHotels() {
		
		List<Hotel> hotelList = hotelRepository.findAll();
		
        if(hotelList.size() > 0) {
        	
        	for(Hotel h : hotelList) {
     		   try {
     				Place p = placeServiceImpl.getPlaceById(h.getPlace_id());
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
	    	Place p = placeServiceImpl.getPlaceById(hotelObj.getPlace_id());
	    	hotelObj.setPlace(p);
	    	return hotelObj;
        } else {
            throw new RecordNotFoundException("No hotel record exist for given hotelId");
        }
	}

	@Override
	public Hotel updateHotel(Hotel newHotel, Place newPlace, String hotelId) {
		
		Optional<Hotel> updatedHotel = hotelRepository.findById(hotelId).map(hotelUpdated -> {
			
			if(hotelUpdated.getNumbOfStars() !=  newHotel.getNumbOfStars()) {
				hotelUpdated.setNumbOfStars(newHotel.getNumbOfStars());
			}
			
			placeServiceImpl.updatePlace(newPlace, newHotel.getPlace());

			return hotelRepository.save(hotelUpdated);
		});

		return (Hotel) updatedHotel.get();
	}

	@Override
	public Hotel createHotel(Hotel newHotel,Place newPlace){
		
		 Place createdPlace = placeServiceImpl.createPlace(newPlace);
		 newHotel.setPlace(createdPlace);
		 
		 return hotelRepository.save(newHotel);
	}

	@Override
	public ResponseEntity<Object> deleteHotel(String hotelId) throws RecordNotFoundException {
		
		Optional<Hotel> periferialDevice = hotelRepository
				.findById(hotelId);
		
		if(periferialDevice.isPresent()) {
			hotelRepository.deleteById(hotelId);
		} else {
	        throw new RecordNotFoundException(
	            "Hotel record with id : " + hotelId + " does not exist !"
	        );
	    }
		
		return ResponseEntity.ok().build();
	}

}
