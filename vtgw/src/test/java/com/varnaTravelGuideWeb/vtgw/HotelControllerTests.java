package com.varnaTravelGuideWeb.vtgw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.context.junit4.SpringRunner;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Hotel;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.utilModels.Image;
import com.varnaTravelGuideWeb.model.utilModels.WorkHours;
import com.varnaTravelGuideWeb.repository.HotelRepository;
import com.varnaTravelGuideWeb.service.impl.HotelServiceImpl;
import com.varnaTravelGuideWeb.service.impl.PlaceServiceImpl;
import com.varnaTravelGuideWeb.service.impl.PriceCategoryServiceImpl;
import com.varnaTravelGuideWeb.service.intrf.HotelServiceI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelControllerTests {
	
	@Rule public ExpectedException exceptionRule = ExpectedException.none();
	 
//	@MockBean 
//	HotelRepository hotelRepository;
//	
	@Autowired 
	HotelServiceImpl hotelServiceImpl;

	@MockBean 
	HotelRepository hotelRepository;
	
	@MockBean 
	PlaceServiceImpl placeServiceImpl;
//	
//	@MockBean 
//	PriceCategoryServiceImpl priceCategoryServiceImpl;

	@Test
	public void getHotelByIdTest() {
		
		//HotelServiceImpl hotelServiceImpl = Mockito.mock(HotelServiceImpl.class);

		try {
			when(hotelRepository.findById("hotel1Id"))
					.thenReturn(
							Optional.of(
				new Hotel("hotel1Id", new ObjectId("place1Id"), 3,null)));

			
			when(placeServiceImpl.getPlaceById(new ObjectId("place1Id").toHexString())).thenReturn(
					
					new Place("place1Id", "Hotel_name", "hotel_address", new GeoJsonPoint(11.11, 22.22),
					"contacts", "description", 2, // hotel
					Arrays.asList(new Image("imageUrl", 1), new Image("imageUrl2", 2)),
					new WorkHours(true, "", "", ""), "BUDGET")
			);
			
			assertEquals("Hotel", hotelServiceImpl.getHotelById("hotel1Id").getClass().getName());
			//assertEquals("Hotel_name", hotelServiceImpl.getHotelById("hotel1Id").getPlace().getName());
			
			
			/*
			 * hotelServiceImpl.getHotelById("exceptionParam");
			 * exceptionRule.expect(RecordNotFoundException.class);
			 */
			 
			
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}


	}
}
