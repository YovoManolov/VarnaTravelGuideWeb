package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToOne;
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
	    @OneToOne(fetch=FetchType.EAGER)
	    @JoinProperty(name = "place")
		private Place place;
	    private String entranceTicket;

}
