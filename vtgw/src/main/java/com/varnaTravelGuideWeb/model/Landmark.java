package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
@Document(collection="landmarks")
public class Landmark {

		@Id
	    private String _id;
		private String place_id;
		private Place place;
	    private String entranceTicket;

}
