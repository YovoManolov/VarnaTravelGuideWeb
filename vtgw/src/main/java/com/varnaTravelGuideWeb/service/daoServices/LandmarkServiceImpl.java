package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.model.Landmark;
import com.varnaTravelGuideWeb.repository.LandmarkRepository;

public class LandmarkServiceImpl implements LandmarkService {

	private LandmarkRepository landmarkRepository;
	//private LandmarkFormToLandmark landmarkFormToLandmark;
	   
	/*
	 * @Autowired public LandmarkServiceImpl(LandmarkRepository landmarkRepository,
	 * LandmarkFormToLandmark landmarkFormToLandmark) { super();
	 * this.landmarkRepository = landmarkRepository; //this.landmarkFormToLandmark =
	 * landmarkFormToLandmark; }
	 */
	
	@Override
	public List<Landmark> listAll() {
        return null;
	}

	
	@Override
	public Landmark getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Landmark saveOrUpdate(Landmark product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Landmark saveOrUpdateLandmarkForm(Landmark landmarkForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
