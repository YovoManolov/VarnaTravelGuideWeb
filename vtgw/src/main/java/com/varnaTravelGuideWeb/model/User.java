package com.varnaTravelGuideWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document(collection = "user")
public class User {
	
	@Id
    private String _id ;
	private Image profileImage;
	@Email
	private String email;
	private String name;
	private String password;
	private boolean isAdmin;
	private boolean enabled;
   	private String imageUrl;

	
    @NotNull
   // @Enumerated(EnumType.STRING)	
    private AuthProvider provider;
    private String providerId;
	
	public User(String _id, Image profileImage, boolean isAdmin) {
		super();
		this._id = _id;
		this.profileImage = profileImage;
		this.isAdmin = isAdmin;
	}
	
	public User() {
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

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}	
}
