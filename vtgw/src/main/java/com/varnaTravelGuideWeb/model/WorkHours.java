package com.varnaTravelGuideWeb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Document
public class WorkHours {
		
	    private boolean is24h;
	    private String monFri;
	    private String sat;
	    private String sun;
}
