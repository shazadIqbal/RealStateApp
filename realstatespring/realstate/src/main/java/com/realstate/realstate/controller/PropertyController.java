package com.realstate.realstate.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realstate.realstate.DTO.PropertyDTO;
import com.realstate.realstate.entity.Property;
import com.realstate.realstate.services.PropertyService;




@RestController
@RequestMapping("/property")	
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public String addProperty(@RequestParam("image") MultipartFile image,PropertyDTO property) {
		property.setImage(image);		
		return propertyService.saveProperty(property);	       
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 public String updateProperty(@RequestParam("image") MultipartFile image,PropertyDTO property,@PathVariable Long id) {
		property.setImage(image);		
		return propertyService.updateProperty(property,id);	       
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Property> getAllprop() {		
		 return propertyService.getALL();  
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Property getById(@PathVariable Long id) {		
		 return propertyService.getById(id);  
    }
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String getById(@PathVariable Long id) {		
//		 Property p = propertyService.getById(id);
//		 return "hello"+p.getName();
//    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Long id) {		
		 return propertyService.deleteProperty(id);  
    }
	
	
	@RequestMapping(value = "/image/{filename:.+}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getImage(@PathVariable("filename") String filename)
	        throws IOException {		
			return propertyService.getPropertyImage(filename);
	}
	
	
}
