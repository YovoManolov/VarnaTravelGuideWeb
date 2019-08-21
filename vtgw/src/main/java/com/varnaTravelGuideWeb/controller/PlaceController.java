package com.varnaTravelGuideWeb.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.repository.PlaceRepository;




@RestController
@RequestMapping(value = "/")
public class PlaceController {
	
	  private final Logger LOG = LoggerFactory.getLogger(getClass());
		private final PlaceRepository placeRepository;
		
		public PlaceController(PlaceRepository placeRepository) {
			this.placeRepository = placeRepository;
		}
		
		@RequestMapping(value = "/{placeId}", method = RequestMethod.GET)
		public Place getPlaceById(@PathVariable String placeId) {
			
			LOG.info("Getting restaurant with placeId: {}.", placeId);
			
			Optional<Place> optionalPlace= placeRepository.findById(placeId);
			if(optionalPlace.isPresent()) {
			    // value is present inside Optional
				return optionalPlace.get();
			} else {
			    // value is absent
				LOG.warn("There is no user for this ID");
			}	
			return placeRepository.findById(placeId).get();
		}
		
		@RequestMapping(value = "", method = RequestMethod.GET)
		public List<Place> getAllplaces(){
			LOG.info("Getting all restaurants.");
			return placeRepository.findAll();
		}

		public Place addNewPlace(@RequestBody Place place){
			LOG.info("Saving restaurant.");
			return placeRepository.save(place);
		}
		
}
