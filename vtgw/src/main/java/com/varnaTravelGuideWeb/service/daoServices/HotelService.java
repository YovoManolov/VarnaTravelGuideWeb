package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import com.varnaTravelGuideWeb.dao.HotelDAO;

public interface HotelService {
	
    List<HotelDAO> listAll();

    HotelDAO getById(String id);

    HotelDAO saveOrUpdate(HotelDAO product);

    void delete(String id);

    HotelDAO saveOrUpdateHotelForm(HotelDAO hotelForm);
}
