package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import com.varnaTravelGuideWeb.dao.PriceCategoryDAO;

public interface PriceCategoryService {
	
    List<PriceCategoryDAO> listAll();

    PriceCategoryDAO getById(String id);

    PriceCategoryDAO saveOrUpdate(PriceCategoryDAO priceCategory);

    void delete(String id);

    PriceCategoryDAO saveOrUpdatePriceCategoryForm(PriceCategoryDAO priceCategoryForm);
}
