package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.dao.LandmarkDAO;
import com.varnaTravelGuideWeb.repository.LandmarkRepository;

public interface LandmarkService {
		
    List<LandmarkDAO> listAll();

    LandmarkDAO getById(String id);

    LandmarkDAO saveOrUpdate(LandmarkDAO product);

    void delete(String id);

    LandmarkDAO saveOrUpdateLandmarkForm(LandmarkDAO landmarkForm);
}
