package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import com.varnaTravelGuideWeb.dao.PlaceDAO;

public interface PlaceService {
	
    List<PlaceDAO> listAll();

    PlaceDAO getById(String id);

    PlaceDAO saveOrUpdate(PlaceDAO product);

    void delete(String id);

    PlaceDAO saveOrUpdatePlaceForm(PlaceDAO placeForm);
}
