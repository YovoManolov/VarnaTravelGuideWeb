package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;
import com.varnaTravelGuideWeb.model.Hotel;

public interface HotelService {
	
    List<Hotel> listAll();

    Hotel getById(String id);

    Hotel saveOrUpdate(Hotel product);

    void delete(String id);

    Hotel saveOrUpdateHotelForm(Hotel hotelForm);
}
