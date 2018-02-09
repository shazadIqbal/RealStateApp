package com.realstate.realstate.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the property database table.
 * 
 */
@Entity
@NamedQuery(name="Property.findAll", query="SELECT p FROM Property p")
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String area;
	private String city;
	private String country;
	private String description;
	private String image;
	private String location;
	private String name;
	private String nearby;
	private Double noOfRooms;
	private String price;
	private String type;
	
	private PropertyOwner propertyOwner;

	public Property() {
	}

	
	
	public Property(String area, String city, String country, String description, String image, String location,
			String name, String nearby, Double noOfRooms, String price, String type) {
		
		this.area = area;
		this.city = city;
		this.country = country;
		this.description = description;
		this.image = image;
		this.location = location;
		this.name = name;
		this.nearby = nearby;
		this.noOfRooms = noOfRooms;
		this.price = price;
		this.type = type;
	}
	
	public Property(Long id,String area, String city, String country, String description, String image, String location,
			String name, String nearby, Double noOfRooms, String price, String type) {
		
		this.id=id;
		this.area = area;
		this.city = city;
		this.country = country;
		this.description = description;
		this.image = image;
		this.location = location;
		this.name = name;
		this.nearby = nearby;
		this.noOfRooms = noOfRooms;
		this.price = price;
		this.type = type;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNearby() {
		return this.nearby;
	}

	public void setNearby(String nearby) {
		this.nearby = nearby;
	}


	@Column(name="no_of_rooms")
	public Double getNoOfRooms() {
		return this.noOfRooms;
	}

	public void setNoOfRooms(Double noOfRooms) {
		this.noOfRooms = noOfRooms;
	}


	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_owner_id")
	public PropertyOwner getPropertyOwner() {
		return this.propertyOwner;
	}

	public void setPropertyOwner(PropertyOwner propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

}