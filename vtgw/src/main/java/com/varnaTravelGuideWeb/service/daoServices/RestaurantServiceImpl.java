package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.model.Restaurant;
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
	public List<Restaurant> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant saveOrUpdate(Restaurant Restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Restaurant saveOrUpdatePriceCategoryForm(Restaurant restaurantForm) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public RestaurantDAO saveOrUpdateRestaurantForm(RestaurantDAO
	 * restaurantForm) { // TODO Auto-generated method stub return null; }
	 */

}
