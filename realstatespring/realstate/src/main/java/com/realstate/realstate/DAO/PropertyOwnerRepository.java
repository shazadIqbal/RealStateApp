package com.realstate.realstate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.realstate.realstate.entity.PropertyOwner;

@Repository
public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long>{

	
}
