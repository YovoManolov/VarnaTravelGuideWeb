package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;

@Document(collection = "user")
public class User {
	
	@Id
    private String _id ;
	private Image profileImage;
	@Email
	private String email;
	private String password;
	private boolean isAdmin;
	private boolean enabled;
	
	public User(String _id, Image profileImage, boolean isAdmin) {
		super();
		this._id = _id;
		this.profileImage = profileImage;
		this.isAdmin = isAdmin;
	}
	
	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public Image getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
