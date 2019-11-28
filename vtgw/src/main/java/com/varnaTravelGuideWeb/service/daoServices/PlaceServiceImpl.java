package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.repository.PlaceRepository;

public class PlaceServiceImpl implements PlaceService {

	private PlaceRepository placeRepository;
	//private PlaceFormToPlace placeFormToPlace;
	   
	/*
	 * @Autowired public PlaceServiceImpl(PlaceRepository placeRepository,
	 * PlaceFormToPlace placeFormToPlace) { this.placeRepository = placeRepository;
	 * //this.placeFormToPlace = placeFormToPlace; }
	 */
	
	@Override
	public List<Place> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place saveOrUpdate(Place product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Place saveOrUpdatePlaceForm(Place placeForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
