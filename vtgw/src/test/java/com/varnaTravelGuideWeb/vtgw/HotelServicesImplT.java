package com.varnaTravelGuideWeb.vtgw;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.varnaTravelGuideWeb.exception.RecordNotFoundException;
import com.varnaTravelGuideWeb.model.Hotel;
import com.varnaTravelGuideWeb.repository.HotelRepository;
import com.varnaTravelGuideWeb.service.impl.HotelServiceImpl;
import com.varnaTravelGuideWeb.service.impl.PlaceServiceImpl;
import com.varnaTravelGuideWeb.vtgw.utilClasses.StaticTestObjects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServicesImplT {
	
	@Rule public ExpectedException exceptionRule = ExpectedException.none();
	
	@MockBean 
	HotelRepository hotelRepository;
	
	@MockBean 
	PlaceServiceImpl placeServiceImpl;
	
	@Autowired 
	HotelServiceImpl hotelServiceImpl;

	@Test
	public void getHotelByIdTest() {
		try {
			when(hotelRepository.findById("hotel1Id")).thenReturn(StaticTestObjects.optionalHotel);
			
			when(placeServiceImpl.getPlaceById(StaticTestObjects.PLACE_ID_HEX))
			.thenReturn(StaticTestObjects.placeToReturn);
			
			assertEquals(
					"com.varnaTravelGuideWeb.model.Hotel", 
					hotelServiceImpl.getHotelById(StaticTestObjects.PLACE_ID_HEX).getClass().getName()
			);
			
			
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getHotelByIdExceptionT() {

		try {
			when(hotelRepository.findById("hotel1Id"))
						.thenReturn(StaticTestObjects.optionalHotel);
			when(placeServiceImpl.getPlaceById(StaticTestObjects.PLACE_ID_HEX))
						.thenReturn(StaticTestObjects.placeToReturn);
			 
			hotelServiceImpl.getHotelById("hotelTestException");
			exceptionRule.expect(RecordNotFoundException.class);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAllHotelsT() {
		try {
			
			when(hotelRepository.findAll()).
					thenReturn(StaticTestObjects.mockedHotelList);
			
			when(placeServiceImpl.getPlaceById(StaticTestObjects.PLACE_ID_1_HEX)).
					thenReturn(StaticTestObjects.placeToReturn);
			
			when(placeServiceImpl.getPlaceById(StaticTestObjects.PLACE_ID_2_HEX)).
					thenReturn(StaticTestObjects.placeToReturn);
			
			when(placeServiceImpl.getPlaceById(StaticTestObjects.PLACE_ID_3_HEX)).
					thenReturn(StaticTestObjects.placeToReturn);
			
			when(placeServiceImpl.getPlaceById(StaticTestObjects.PLACE_ID_4_HEX)).
					thenReturn(StaticTestObjects.placeToReturn);
			
		   List<Hotel> allHotels = hotelServiceImpl.getAllHotels();
		   for(Hotel h : allHotels) {
			  assertNotNull(h.getPlace());
			  assertEquals(StaticTestObjects.PLACE_ID_HEX, h.getPlace().get_id());
		   }
		   
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
