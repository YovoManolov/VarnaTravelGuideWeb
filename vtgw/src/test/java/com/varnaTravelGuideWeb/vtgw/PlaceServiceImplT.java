package com.varnaTravelGuideWeb.vtgw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.context.junit4.SpringRunner;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.utilModels.Image;
import com.varnaTravelGuideWeb.model.utilModels.WorkHours;
import com.varnaTravelGuideWeb.repository.PlaceRepository;
import com.varnaTravelGuideWeb.service.impl.PlaceServiceImpl;
import com.varnaTravelGuideWeb.service.impl.PriceCategoryServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceServiceImplT {
	
	@Rule public ExpectedException exceptionRule = ExpectedException.none();
	
	@MockBean
	private PlaceRepository placeRepository;
	
	@MockBean
	private PriceCategoryServiceImpl priceCategorySerciceImpl;
	
	@Autowired 
	private PlaceServiceImpl placeServiceImpl;

	private Optional<Place> optionalPlace = Optional.of(
			new Place(
					"place1Id",
					"SomePlace_name",
					"hotel_address",
					new GeoJsonPoint(11.11, 22.22),
					"contacts",
					"description",
					2, // hotel
					Arrays.asList(
						new Image("imageUrl", 1),
						new Image("imageUrl2", 2)
					),
					new WorkHours(true, "", "", ""),
					"BUDGET"
			)
		);
	
	
	private Place originalPlace = 
			new Place(
					"place1Id",
					"SomePlace_name",
					"hotel_address",
					new GeoJsonPoint(11.11, 22.22),
					"contacts",
					"description",
					2, // hotel
					Arrays.asList(
						new Image("imageUrl", 1),
						new Image("imageUrl2", 2)
					),
					new WorkHours(true, "", "", ""),
					"BUDGET"
			);
	
	private Place placeToUpdateWith = 
			new Place(
					"place1Id",
					"SomePlace_name2",
					"hotel_address2",
					new GeoJsonPoint(11.11, 22.22),
					"contacts2",
					"description",
					2, // hotel
					Arrays.asList(
						new Image("imageUrl", 1),
						new Image("imageUrl2", 2)
					),
					new WorkHours(true, "", "", ""),
					"BUDGET"
			);
	
	@Test
	public void getPlaceByIdT() {
		
		try {
			when(placeRepository.findById("place1Id")).thenReturn(optionalPlace);
			
			when(priceCategorySerciceImpl.getPriceCategoryDescrByPlaceId("place1Id"))
			.thenReturn("BUDGET");
			
			assertEquals("com.varnaTravelGuideWeb.model.Place", placeServiceImpl.getPlaceById("place1Id").getClass().getName());
			assertEquals("SomePlace_name", placeServiceImpl.getPlaceById("place1Id").getName());
			
			
			placeServiceImpl.getPlaceById("placeTestException");
			  exceptionRule.expect(RecordNotFoundException.class);
			 
			
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getPlaceByIdExceptionT() {
		
		try {
			when(placeRepository.findById("place1Id")).thenReturn(optionalPlace);
			
			when(priceCategorySerciceImpl.getPriceCategoryDescrByPlaceId("place1Id"))
			.thenReturn("BUDGET");
			
			placeServiceImpl.getPlaceById("placeTestException");
			  exceptionRule.expect(RecordNotFoundException.class);
			 
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updatePlaceT() {
		
		assertEquals("SomePlace_name", originalPlace.getName());
		assertEquals("hotel_address", originalPlace.getAddress());
		
		when(placeRepository.save(originalPlace)).thenReturn(placeToUpdateWith);
		
		Place updatedPlace = placeServiceImpl.updatePlace(placeToUpdateWith,originalPlace);
		
		assertEquals("SomePlace_name2", updatedPlace.getName());
		assertEquals("hotel_address2", updatedPlace.getAddress());
	}
}
