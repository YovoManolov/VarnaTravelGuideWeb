package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import com.varnaTravelGuideWeb.model.PriceCategory;

public interface PriceCategoryService {
	
    List<PriceCategory> listAll();

    PriceCategory getById(String id);

    PriceCategory saveOrUpdate(PriceCategory priceCategory);

    void delete(String id);

    PriceCategory saveOrUpdatePriceCategoryForm(PriceCategory priceCategoryForm);
}
