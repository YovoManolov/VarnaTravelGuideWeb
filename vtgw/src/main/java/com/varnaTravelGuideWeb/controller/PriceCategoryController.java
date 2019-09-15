package com.varnaTravelGuideWeb.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varnaTravelGuideWeb.entity.PriceCategory;
import com.varnaTravelGuideWeb.repository.PriceCategoryRepository;

@RestController
@RequestMapping(value = "/")
public class PriceCategoryController {
	
	
	 private final Logger LOG = LoggerFactory.getLogger(getClass());
		private final PriceCategoryRepository priceCategoryRepository;
		
		public PriceCategoryController(PriceCategoryRepository priceCategoryRepository) {
			this.priceCategoryRepository = priceCategoryRepository;
		}
	

	@RequestMapping(value = "/{placeId}", method = RequestMethod.GET)
	public PriceCategory getPriceCategoryById(@PathVariable String priceCategoryId) {
		
		LOG.info("Getting restaurant with placeId: {}.", priceCategoryId);
		
		Optional<PriceCategory> optionalPlace= priceCategoryRepository.getPriceCategoryById(priceCategoryId);
		if(optionalPlace.isPresent()) {
		    // value is present inside Optional
			return optionalPlace.get();
		} else {
		    // value is absent
			LOG.warn("There is no user for this ID");
		}	
		return priceCategoryRepository.getPriceCategoryById(priceCategoryId).get();
	}
	
	
}
