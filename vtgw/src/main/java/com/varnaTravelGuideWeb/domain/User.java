package com.varnaTravelGuideWeb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Set;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.mapping.DBRef;


import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
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
