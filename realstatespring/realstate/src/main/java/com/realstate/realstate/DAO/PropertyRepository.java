package com.realstate.realstate.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realstate.realstate.DTO.PropertyDTO;
import com.realstate.realstate.entity.Property;



@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{

	
	 @Query("SELECT new com.realstate.realstate.entity.Property(p.id,p.area,p.city,p.country,p.description,p.image,p.location,p.name,p.nearby,p.noOfRooms,p.price,p.type) FROM Property p")
	    public List<Property> getAllUIProperty();
	 

	 public List<Property> findByNameContaining(String name);
	
	
}
