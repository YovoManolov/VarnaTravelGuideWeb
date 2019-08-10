package com.varnaTravelGuideWeb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class PriceCategoryController {
	public PriceCategory getPriceCategoryById(int priceCategoryId);
}
