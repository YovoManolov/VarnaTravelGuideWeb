package com.varnaTravelGuideWeb.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Place {
	
	@Id
	@Field("_id")
	private String id;
    private String name;	
    private String address;
    private Double latitude;
    private Double longitude;
    private String contacts;
    private String description;
    private Integer typeOfPlace;
    private Integer priceCategoryId;
    private ArrayList<Image> images;
    private WorkHours workHours;

	/*
	 * public Place(final Document document) {
	 * 
	 * _id = document.getString("_id"); name = document.getString("name"); address =
	 * document.getString("address"); latitude = document.getDouble("latitude");
	 * longitude = document.getDouble("longitude"); contacts =
	 * document.getString("contacts"); description =
	 * document.getString("description"); typeOfPlace =
	 * document.getInteger("typeOfPlace"); priceCategoryId =
	 * document.getInteger("priceCategory"); images =
	 * Image.convertDocsToImages((ArrayList<Document>) document.get("images"));
	 * workHours = new WorkHours((Document)document.get("workHours")); }
	 */
    
    public String getName() {
        return name;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public Integer getTypeOfPlace() {
        return typeOfPlace;
    }

    public void setTypeOfPlace(Integer typeOfPlace) {
        this.typeOfPlace = typeOfPlace;
    }

    public WorkHours getWorkHours() {
        return workHours;
    }

    public void setWorkHours(WorkHours workHours) {
        this.workHours = workHours;
    }

    public void setPriceCategoryId(Integer priceCategoryId) {
        this.priceCategoryId = priceCategoryId;
    }

    public Integer getPriceCategoryId() {
        return priceCategoryId;
    }

}
