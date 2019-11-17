package com.varnaTravelGuideWeb.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varnaTravelGuideWeb.dao.HotelDAO;
import com.varnaTravelGuideWeb.repository.HotelRepository;

@Controller
public class HotelController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final HotelRepository hotelRepository;
	
	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@RequestMapping(value = "/{placeId}", method = RequestMethod.GET)
	public HotelDAO getHotelByPlaceId(@PathVariable String placeId) {
		
		LOG.info("Getting hotel with placeId: {}.", placeId);
		
		Optional<HotelDAO> optionalHotel = hotelRepository.findByPlaceId(placeId);
		if(optionalHotel.isPresent()) {
		    // value is present inside Optional
			return optionalHotel.get();
		} else {
		    // value is absent
			LOG.warn("There is no user for this ID");
		}	
		return hotelRepository.findByPlaceId(placeId).get();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<HotelDAO> getAllHotels(){
		LOG.info("Getting all hotels.");
		return hotelRepository.findAll();
	}

	public HotelDAO addNewHotel(@RequestBody HotelDAO hotel){
		LOG.info("Saving hotel.");
		return hotelRepository.save(hotel);
	}
	
}
