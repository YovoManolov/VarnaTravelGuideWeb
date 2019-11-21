package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.dao.PlaceDAO;
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
	public List<PlaceDAO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlaceDAO getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlaceDAO saveOrUpdate(PlaceDAO product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public PlaceDAO saveOrUpdatePlaceForm(PlaceDAO placeForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
