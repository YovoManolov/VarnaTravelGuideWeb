package com.varnaTravelGuideWeb.vtgw;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.varnaTravelGuideWeb.repository.HotelRepository;
import com.varnaTravelGuideWeb.service.impl.HotelServiceImpl;
import com.varnaTravelGuideWeb.service.impl.PlaceServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelControllerTests {
	
	@Autowired 
	private HotelServiceImpl hotelServiceImpl;
	
	@MockBean
	private HotelRepository hotelRepository;
	
	@Mock
	private PlaceServiceImpl placeServiceImpl;
	
	@Test
	public void findAllHotelsTest() {
		/*
		 * when(hotelServiceImpl.getAllHotels()) .thenReturn( Stream.of( new
		 * HotelHotel("5c72dc032c0f1304b4972319",new
		 * ObjectId("5c72c5d22c0f1304b47a2819"), 3, new
		 * Place("c72c5d22c0f1304b47a2819","Akropolis",
		 * "13 Tsar Ivan Shishman, 9000 Varna Center" ,new
		 * GeoJsonPoint(27.958885,43.217500) ,
		 * 
		 * location=Point [x=27.958885, y=43.217500], contacts=LL: 052 603 108
		 * Cell./Mob. : +359 898 506 505 e-mail: hotel_acropolis@yahoo.com
		 * www.hotelacropolis.net , description= The family hotel "Acropolis" is
		 * situated in a quiet and peaceful place in the trade center of Varna, in the
		 * most prestigious district of Varna - the Greek quarter. It is located next to
		 * the the train station, Varna Custom house, 50 meters from the Varna beach and
		 * the beautiful Sea Garden., typeOfPlace=2,
		 * 
		 * images=[ Image(imageURL=1dhQc8Pi7f12b0H49qJuDoB32sYfqTFfH, mainImage=1),
		 * Image(imageURL=1HN5CoUFeOE_ztGo6ewxTeozq0R9Tq2z6, mainImage=0),
		 * Image(imageURL=1Ox9LhM_EJIis1GdDF9BEc79CwsszsMTM, mainImage=0),
		 * Image(imageURL=1DO-lm6_flmc7ZSq8oayHfmYL7SBh2sXY, mainImage=0),
		 * Image(imageURL=1LWyZaGsgFg7BZ_LIOJKpZJsXGfW4iETJ, mainImage=0) ],
		 * workHours=WorkHours(is_24H=true, mond_fird= , sat= , sun= ),
		 * priceCategoryDescription=BUDGET) ), any(Hotel.class), any(Hotel.class) )
		 * .collect(Collectors.toList()) );
		 * 
		 * assertEquals(3, hotelServiceImpl.getAllHotels().size());
		 */
	}
}
