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

import com.varnaTravelGuideWeb.model.Landmark;
import com.varnaTravelGuideWeb.repository.LandmarkRepository;

@Controller
public class LandmarkController {
		
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final LandmarkRepository landmarkRepository;
	
	public LandmarkController(LandmarkRepository landmarkRepository) {
		this.landmarkRepository = landmarkRepository;
	}
	
	@RequestMapping(value = "/{placeId}", method = RequestMethod.GET)
	public Landmark getLandmarkByPlaceId(@PathVariable String placeId) {
		
		LOG.info("Getting Landmark with placeId: {}.", placeId);
		
		Optional<Landmark> optionalLandmark = landmarkRepository.findByPlaceId(placeId);
		if(optionalLandmark.isPresent()) {
		    // value is present inside Optional
			return optionalLandmark.get();
		} else {
		    // value is absent
			LOG.warn("There is no user for this ID");
		}	
		return landmarkRepository.findByPlaceId(placeId).get();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Landmark> getAllLandmarks(){
		LOG.info("Getting all Landmarks.");
		return landmarkRepository.findAll();
	}

	public Landmark addNewLandmark(@RequestBody Landmark landmark){
		LOG.info("Saving landmark.");
		return landmarkRepository.save(landmark);
	}
	
}
