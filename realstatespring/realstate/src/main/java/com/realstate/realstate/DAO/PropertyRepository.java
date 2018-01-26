package com.realstate.realstate.DAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realstate.realstate.entity.Property;



@Repository
public interface PropertyRepository extends CrudRepository<Property, Long>{

}
