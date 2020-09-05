package com.varnaTravelGuideWeb.vtgw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.bson.types.ObjectId;
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
import com.varnaTravelGuideWeb.model.Hotel;
import com.varnaTravelGuideWeb.model.Place;
import com.varnaTravelGuideWeb.model.utilModels.Image;
import com.varnaTravelGuideWeb.model.utilModels.WorkHours;
import com.varnaTravelGuideWeb.repository.HotelRepository;
import com.varnaTravelGuideWeb.service.impl.HotelServiceImpl;
import com.varnaTravelGuideWeb.service.impl.PlaceServiceImpl;

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

	private static final String PLACE_ID_HEX = "5c72c5d22c0f1304b47a2818";
	
	private Optional<Hotel> optionalHotel = Optional.of(
			new Hotel("hotel1Id", new ObjectId(PLACE_ID_HEX), 3,null));
	
	private static final Place placeToReturn = new Place(
											"5c72c5d22c0f1304b47a2818",
											"Hotel_name",
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

	@Test
	public void getHotelByIdTest() {
		try {
			when(hotelRepository.findById("hotel1Id")).thenReturn(optionalHotel);
			
			when(placeServiceImpl.getPlaceById(PLACE_ID_HEX))
			.thenReturn(placeToReturn);
			
			assertEquals(
					"com.varnaTravelGuideWeb.model.Hotel", 
					hotelServiceImpl.getHotelById(PLACE_ID_HEX).getClass().getName()
			);
			
			
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getHotelByIdExceptionT() {

		try {
			when(hotelRepository.findById("hotel1Id")).thenReturn(optionalHotel);
			when(placeServiceImpl.getPlaceById(PLACE_ID_HEX)).thenReturn(placeToReturn);
			 
			hotelServiceImpl.getHotelById("hotelTestException");
			exceptionRule.expect(RecordNotFoundException.class);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
}
