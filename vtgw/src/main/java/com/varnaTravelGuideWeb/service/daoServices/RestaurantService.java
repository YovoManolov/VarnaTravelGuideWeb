package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import com.varnaTravelGuideWeb.model.Restaurant;

public interface RestaurantService {

    List<Restaurant> listAll();

    Restaurant getById(String id);

    Restaurant saveOrUpdate(Restaurant priceCategory);

    void delete(String id);

    Restaurant saveOrUpdatePriceCategoryForm(Restaurant restaurantForm);
}
