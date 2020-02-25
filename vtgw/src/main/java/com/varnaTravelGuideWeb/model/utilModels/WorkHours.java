package com.varnaTravelGuideWeb.model.utilModels;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class WorkHours {
	
	    private Boolean is24h;
	    @Nullable
	    private String monFri;
	    @Nullable
	    private String sat;
	    @Nullable
	    private String sun;
}
