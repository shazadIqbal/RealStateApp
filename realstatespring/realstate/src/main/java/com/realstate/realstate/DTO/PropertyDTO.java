package com.realstate.realstate.DTO;

import org.springframework.web.multipart.MultipartFile;

public class PropertyDTO {

    private String name;
    private String address;
    private String details;
    private MultipartFile image;    
    

	public String getName() {
		return name;
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
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}

    

}