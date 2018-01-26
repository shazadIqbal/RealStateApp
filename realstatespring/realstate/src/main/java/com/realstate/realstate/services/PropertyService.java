package com.realstate.realstate.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.realstate.realstate.DAO.PropertyRepository;
import com.realstate.realstate.DTO.PropertyDTO;
import com.realstate.realstate.entity.Property;


@Service
public class PropertyService {

	@Autowired
	private PropertyRepository propertyRepositry;
	
	//@Value("${path}")
		private static String UPLOADED_FOLDER="C://serverfiles//";
		
		private static String IMAGE_URL="http:/localhost:8080/property/";
		
		
		public String saveProperty(PropertyDTO property){
			
			if(savePropertyImage(property.getImage())){
				String imageURL = IMAGE_URL+property.getImage().getOriginalFilename();
				Property p = new Property(property.getName(), property.getAddress(), property.getDetails(), imageURL);
				propertyRepositry.save(p);			
				
			}else{
				return "There is some problem Property NOT Saved!!";	
			}

		        return "Property Successfully Saved";	
		}
		
		public Boolean savePropertyImage(MultipartFile file){
			 try {			 
		            // Get the file and save it somewhere
		            byte[] bytes = file.getBytes();
		            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		            Files.write(path, bytes);
	  
		        } catch (IOException e) {
		            e.printStackTrace();
		            return false;
		        }

		        return true;	
		}
		public ResponseEntity<InputStreamResource> getPropertyImage(String filename) throws IOException{
			  String filepath = UPLOADED_FOLDER+filename;
				 File f = new File(filepath);
		         Resource file = new UrlResource(f.toURI());
				
		         return ResponseEntity
		                 .ok()
		                 .contentLength(file.contentLength())
		                 .contentType(
		                         MediaType.parseMediaType("image/JPG"))
		                 .body(new InputStreamResource(file.getInputStream()));
		         
		}
}
