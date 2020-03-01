package com.varnaTravelGuideWeb.service.intrf;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Hotel;

public interface HotelServiceI {

	public List<Hotel> getAllHotels();

	public Hotel getHotelById(@PathVariable(value = "id") String hotelId) throws RecordNotFoundException;

	public Hotel updateHotel(Hotel newHotel, String hotelId) throws RecordNotFoundException;

	public Hotel createHotel(Hotel newHotel);

	public ResponseEntity<Object> deleteHotel(String hotelId) throws RecordNotFoundException;

}