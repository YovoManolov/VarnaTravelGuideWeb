package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Document
public class WorkHours {
		
		@Id
		private String _id;
	    private boolean is24h;
	    private String monFri;
	    private String sat;
	    private String sun;
}
