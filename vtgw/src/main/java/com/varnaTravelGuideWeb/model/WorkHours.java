package com.varnaTravelGuideWeb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class WorkHours {
		
	    private boolean is24h;
	    private String monFri;
	    private String sat;
	    private String sun;
}
