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
import com.varnaTravelGuideWeb.model.Landmark;
import com.varnaTravelGuideWeb.service.impl.LandmarkServiceImpl;

@RestController
@RequestMapping("/landmarks")
public class LandmarkController {

	@Autowired
	LandmarkServiceImpl landmarkServiceImpl;

	@GetMapping("/getAll")
	public ResponseEntity<List<Landmark>> getAllShoppingLandmarks() {
		List<Landmark> landmarkList = landmarkServiceImpl.getAllLandmarks();
		return new ResponseEntity<List<Landmark>>(landmarkList, HttpStatus.OK);
	}

	@GetMapping("/getOneById/{id}")
	public ResponseEntity<Landmark> getLandmarkById(@PathVariable(value = "id") String landmarkId)
			throws RecordNotFoundException {
		Landmark landmark = landmarkServiceImpl.getLandmarkById(landmarkId);
		return new ResponseEntity<Landmark>(landmark, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Landmark> createLandmark(@RequestBody Landmark landmark) {
		Landmark createdLandmark = landmarkServiceImpl.createLandmark(landmark);
		return new ResponseEntity<Landmark>(createdLandmark, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Landmark> updateLandmark(@RequestBody Landmark newLandmark,
			@PathVariable(value = "id") String landmarkId) throws RecordNotFoundException {

		Landmark updatedLandmark = landmarkServiceImpl.updateLandmark(newLandmark, landmarkId);
		
		return new ResponseEntity<Landmark>(updatedLandmark, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Object> deleteLandmarkById(@PathVariable("id") String landmarkId)
			throws RecordNotFoundException {
		return landmarkServiceImpl.deleteLandmark(landmarkId);
	}
}
