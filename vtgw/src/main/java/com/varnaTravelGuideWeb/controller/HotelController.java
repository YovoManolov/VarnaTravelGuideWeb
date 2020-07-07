package com.varnaTravelGuideWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Hotel;
import com.varnaTravelGuideWeb.service.impl.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImpl;

	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> hotelList = hotelServiceImpl.getAllHotels();
		return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.OK);
	}

	@GetMapping("/getOneById/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable(value = "id") String hotelId)
			throws RecordNotFoundException {
		Hotel hotel = hotelServiceImpl.getHotelById(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {

		Hotel createdHotel = hotelServiceImpl.createHotel(hotel);
		return new ResponseEntity<Hotel>(createdHotel, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable(value = "id") String hotelId, @RequestBody Hotel newHotel)
			throws RecordNotFoundException {
		
		Hotel updatedShoppingHotel = hotelServiceImpl.updateHotel(newHotel ,hotelId);
		return new ResponseEntity<Hotel>(updatedShoppingHotel, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Object> deleteHotelById(@PathVariable("id") String hotelId)
			throws RecordNotFoundException {
		return  hotelServiceImpl.deleteHotel(hotelId);
	}
}
