package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.dao.PriceCategoryDAO;
import com.varnaTravelGuideWeb.repository.PriceCategoryRepository;

public class PriceCategoryServiceImpl implements PriceCategoryService {

	private PriceCategoryRepository priceCategoryRepository;
	private PriceCategoryFormToPriceCategory priceCategoryFormToPriceCategory;
	
	@Autowired
    public PriceCategoryServiceImpl(PriceCategoryRepository priceCategoryRepository, PriceCategoryFormToPriceCategory priceCategoryFormToPriceCategory) {
    	this.priceCategoryRepository = priceCategoryRepository;
    	this.priceCategoryFormToPriceCategory = priceCategoryFormToPriceCategory;
    }     
	
	@Override
	public List<PriceCategoryDAO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceCategoryDAO getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceCategoryDAO saveOrUpdate(PriceCategoryDAO priceCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public PriceCategoryDAO saveOrUpdatePriceCategoryForm(PriceCategoryDAO priceCategoryForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
