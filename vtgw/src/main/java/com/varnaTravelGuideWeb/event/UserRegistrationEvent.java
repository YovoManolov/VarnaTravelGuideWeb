package com.varnaTravelGuideWeb.event;

import org.springframework.context.ApplicationEvent;

import com.varnaTravelGuideWeb.domain.User;

import lombok.Getter;

@Getter
public class UserRegistrationEvent extends ApplicationEvent {

	private static final long serialVersionUID = -4113549487933175429L;
	private final User user;
	
	public UserRegistrationEvent(User user) {
		super(user);
		this.user=user;
	}

}
