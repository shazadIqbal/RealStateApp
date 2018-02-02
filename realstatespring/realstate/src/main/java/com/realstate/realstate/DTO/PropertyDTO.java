package com.realstate.realstate.DTO;

import org.springframework.web.multipart.MultipartFile;

public class PropertyDTO {

    private String name;
    private String location;
    private String city;
    private MultipartFile image;   
    private String country;
    private String nearBy;
    private String price;
	private String description;
	private String type;
	private String area;
	private Double noOfRooms;
    private PropertyOwnerDetailsDTO propertyOwnerDetails;    
    

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNearBy() {
		return nearBy;
	}
	public void setNearBy(String nearBy) {
		this.nearBy = nearBy;
	}
	public PropertyOwnerDetailsDTO getPropertyOwnerDetails() {
		return propertyOwnerDetails;
	}
	public void setPropertyOwnerDetails(PropertyOwnerDetailsDTO propertyOwnerDetails) {
		this.propertyOwnerDetails = propertyOwnerDetails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Double getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(Double noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	
	

    

}