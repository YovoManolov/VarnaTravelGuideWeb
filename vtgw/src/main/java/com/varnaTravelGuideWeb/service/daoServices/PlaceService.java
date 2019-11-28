package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import com.varnaTravelGuideWeb.model.Place;

public interface PlaceService {
	
    List<Place> listAll();

    Place getById(String id);

    Place saveOrUpdate(Place product);

    void delete(String id);

    Place saveOrUpdatePlaceForm(Place placeForm);
}
