package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import com.varnaTravelGuideWeb.dao.RestaurantDAO;

public interface RestaurantService {

    List<RestaurantDAO> listAll();

    RestaurantDAO getById(String id);

    RestaurantDAO saveOrUpdate(RestaurantDAO priceCategory);

    void delete(String id);

    RestaurantDAO saveOrUpdatePriceCategoryForm(RestaurantDAO restaurantForm);
}
