package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.model.Landmark;
import com.varnaTravelGuideWeb.repository.LandmarkRepository;

public interface LandmarkService {
		
    List<Landmark> listAll();

    Landmark getById(String id);

    Landmark saveOrUpdate(Landmark product);

    void delete(String id);

    Landmark saveOrUpdateLandmarkForm(Landmark landmarkForm);
}
