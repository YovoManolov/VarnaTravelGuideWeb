package com.varnaTravelGuideWeb.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "user")
public class User {	
	
	@Id
	private String userId;
	private String email;
	private String password;
	private String fullname;
	private boolean enabled;
	@DBRef
	private Set<Role> roles;
}
