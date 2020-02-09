package com.varnaTravelGuideWeb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "role")
public class Role {
	
		@Id
	    private String id;
	    private String role;
}
