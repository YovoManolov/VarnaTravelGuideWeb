package com.varnaTravelGuideWeb.service.intrf;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Landmark;
import com.varnaTravelGuideWeb.model.Place;

public interface LandmarkServiceI {

	public List<Landmark> getAllLandmarks();

	public Landmark getLandmarkById(@PathVariable(value = "id") String landmarkId) throws RecordNotFoundException;

	public Landmark updateLandmark(Landmark newLandmark, String landmarkId) throws RecordNotFoundException;

	public Landmark createLandmark(Landmark newLandmark, Place newPlace);

	public ResponseEntity<Object> deleteLandmark(String landmarkId) throws RecordNotFoundException;
}
