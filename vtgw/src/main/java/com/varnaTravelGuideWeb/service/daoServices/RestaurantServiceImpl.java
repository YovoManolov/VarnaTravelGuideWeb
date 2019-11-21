package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.dao.RestaurantDAO;
import com.varnaTravelGuideWeb.repository.RestaurantRepository;

public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepository restaurantRepository;
//	private RestaurantFormToRestaurant restaurantFormToRestaurant;
	
	/*
	 * @Autowired public RestaurantServiceImpl(RestaurantRepository
	 * restaurantRepository, RestaurantFormToRestaurant restaurantFormToRestaurant)
	 * { this.restaurantRepository = restaurantRepository;
	 * //this.restaurantFormToRestaurant = restaurantFormToRestaurant; }
	 */
	@Override
	public List<RestaurantDAO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDAO getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDAO saveOrUpdate(RestaurantDAO Restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RestaurantDAO saveOrUpdatePriceCategoryForm(RestaurantDAO restaurantForm) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public RestaurantDAO saveOrUpdateRestaurantForm(RestaurantDAO
	 * restaurantForm) { // TODO Auto-generated method stub return null; }
	 */

}
