package com.realstate.realstate.controller;



import java.io.IOException;

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
import com.realstate.realstate.services.PropertyService;




@RestController
@RequestMapping("/property")	
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public String addProperty(@RequestParam("image") MultipartFile image,PropertyDTO property) {
		property.setImage(image);
		//System.out.println(property);
		
		return propertyService.saveProperty(property);	
       
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String property) {
		
		 //propertyService.saveProperty(property);
	        return "File Saved";	
       
    }
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getprop() {
		
		 //propertyService.saveProperty(property);
	        return "File Saved";	
       
    }
	
	
	@RequestMapping(value = "/{filename:.+}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getImage(@PathVariable("filename") String filename)
	        throws IOException {
		
			return propertyService.getPropertyImage(filename);
	}
	
	
}
