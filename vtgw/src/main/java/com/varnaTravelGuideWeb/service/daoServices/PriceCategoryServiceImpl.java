package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.model.PriceCategory;
import com.varnaTravelGuideWeb.repository.PriceCategoryRepository;

public class PriceCategoryServiceImpl implements PriceCategoryService {

	private PriceCategoryRepository priceCategoryRepository;
	//private PriceCategoryFormToPriceCategory priceCategoryFormToPriceCategory;
	
	/*
	 * @Autowired public PriceCategoryServiceImpl(PriceCategoryRepository
	 * priceCategoryRepository, PriceCategoryFormToPriceCategory
	 * priceCategoryFormToPriceCategory) { this.priceCategoryRepository =
	 * priceCategoryRepository; this.priceCategoryFormToPriceCategory =
	 * priceCategoryFormToPriceCategory; }
	 */	
	@Override
	public List<PriceCategory> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceCategory getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceCategory saveOrUpdate(PriceCategory priceCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public PriceCategory saveOrUpdatePriceCategoryForm(PriceCategory priceCategoryForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
