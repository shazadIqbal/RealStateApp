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

	
//	 @Query("SELECT new p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//	    public List<PropertyDTO> getAllProperty();
	
}
