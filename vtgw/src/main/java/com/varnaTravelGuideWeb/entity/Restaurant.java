package com.varnaTravelGuideWeb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Document
@Getter
@RequiredArgsConstructor
public class Restaurant {
	
	@Id
	private String _id ;
	@Field("place_id")
    private String placeId;
    private String cuisine;

   

    /* public static Restaurant[] populateRestaurants() {
        return new Restaurant[]{
                new Restaurant(1, 2, "Bulgarian, European and Mediterranean cuisine."),
                new Restaurant(2, 1, "PIZZA, PASTA & WINE "),
                new Restaurant(3, 3, "\n" + "The dishes are a combination of modern cuisine" +
                                " with elements of the highest French cuisine and traditional" +
                                "Bulgarian dishes."),
                new Restaurant(4, 3, "European cuisine."),
                new Restaurant(5, 1, "\n European, american cuisine, sandwiches, cold, pancakes,"
                                + " cocktails, alcohol and beverages, draft beer," +
                                "fast food, desserts, burgers.")
        };
    }*/
}
