package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.model.Hotel;
import com.varnaTravelGuideWeb.repository.HotelRepository;

public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
   // private HotelFormToHotel hotelFormToHotel;
    
	/*
	 * @Autowired public HotelServiceImpl(HotelRepository hotelRepository,
	 * HotelFormToHotel hotelFormToHotel) { this.hotelRepository = hotelRepository;
	 * //this.hotelFormToHotel = hotelFormToHotel; }
	 */
	@Override
	public List<Hotel> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel saveOrUpdate(Hotel product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Hotel saveOrUpdateHotelForm(Hotel hotelForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
