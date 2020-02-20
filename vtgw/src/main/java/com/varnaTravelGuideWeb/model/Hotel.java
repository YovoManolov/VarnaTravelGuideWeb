package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@AllArgsConstructor
@Document(collection="hotels")
public class Hotel {
		
		@Id
	    private String _id ;
	    @OneToOne(fetch=FetchType.EAGER)
	    @JoinProperty(name = "place")
		private Place place;
	    private int numbOfStars;
	    
}
