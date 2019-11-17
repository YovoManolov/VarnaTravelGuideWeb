package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.dao.HotelDAO;
import com.varnaTravelGuideWeb.repository.HotelRepository;

public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private HotelFormToHotel hotelFormToHotel;
    
    @Autowired
	public HotelServiceImpl(HotelRepository hotelRepository, HotelFormToHotel hotelFormToHotel) {
		this.hotelRepository = hotelRepository;
		this.hotelFormToHotel = hotelFormToHotel;
	}

	@Override
	public List<HotelDAO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelDAO getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelDAO saveOrUpdate(HotelDAO product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public HotelDAO saveOrUpdateHotelForm(HotelDAO hotelForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
