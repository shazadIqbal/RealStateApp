package com.realstate.realstate.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the property_owner database table.
 * 
 */
@Entity
@Table(name="property_owner")
@NamedQuery(name="PropertyOwner.findAll", query="SELECT p FROM PropertyOwner p")
public class PropertyOwner implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long propertyOwnerId;
	private String address;
	private String contact;
	private Double demand;
	private String name;
	@JsonIgnore
	private Property property;

	public PropertyOwner() {
	}
	
	

	public PropertyOwner(String address, String contact, Double demand, String name) {
		
		this.address = address;
		this.contact = contact;
		this.demand = demand;
		this.name = name;
	}



	@Id
	@Column(name="property_owner_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getPropertyOwnerId() {
		return this.propertyOwnerId;
	}

	public void setPropertyOwnerId(Long propertyOwnerId) {
		this.propertyOwnerId = propertyOwnerId;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}


	public Double getDemand() {
		return this.demand;
	}

	public void setDemand(Double demand) {
		this.demand = demand;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 @OneToOne(mappedBy = "propertyOwner")
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property propertyBean) {
		this.property = propertyBean;
	}

}