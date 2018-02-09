package com.realstate.realstate.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.realstate.realstate.DAO.PropertyOwnerRepository;
import com.realstate.realstate.DAO.PropertyRepository;
import com.realstate.realstate.DTO.PropertyDTO;
import com.realstate.realstate.entity.Property;
import com.realstate.realstate.entity.PropertyOwner;


@Service
public class PropertyService {

	@Autowired
	private PropertyRepository propertyRepositry;
	
	
		private static String UPLOADED_FOLDER="C://serverfiles//";
		
		private static String IMAGE_URL="http://localhost:8080/property/image/";
		
		
		public String saveProperty(PropertyDTO property){
			
			if(savePropertyImage(property.getImage())){
				String imageURL = IMAGE_URL+property.getImage().getOriginalFilename();						
				Property pro = populateProperty(property, imageURL);
				propertyRepositry.save(pro);	
						
				
			}else{
				return "There is some problem Property NOT Saved!!";	
			}

		        return "Property Successfully Saved";	
		}
		
		public String updateProperty(PropertyDTO property,Long id){
			
			if(savePropertyImage(property.getImage())){
				String imageURL = IMAGE_URL+property.getImage().getOriginalFilename();				
				Property pro = updatePropertyRecord(property, imageURL,id);
				
				propertyRepositry.save(pro);		
				
			}else{
				return "There is some problem Property NOT update!!";	
			}

		        return "Property Successfully update";	
		}
		
		public Boolean savePropertyImage(MultipartFile file){
			 try {			 
		            // Get the file and save it somewhere
				 File dir = new File(UPLOADED_FOLDER);
				 if(!dir.exists()){
					dir.mkdirs(); 
				 }
				 
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
		
		public List<Property> getALL(){					
			return propertyRepositry.findAll();
		}
		
		public List<Property> getALLUI(){					
			return propertyRepositry.getAllUIProperty();
		}
		
		public Property getById(Long id){					
			return propertyRepositry.findOne(id);
		}
		
		public String deleteProperty(Long id){
			
			if (deleteImage(id)) {
				propertyRepositry.delete(id);
				return "delete successfully";
			}
			
			
			return "unsuccessful delete operation somthing happen wrong";
		}
		
		public boolean deleteImage(Long id){
			Property prop = getById(id);
			String imageName = prop.getImage().substring(prop.getImage().lastIndexOf('/')+1);
			System.out.println(imageName);
			
			 File file = new File(UPLOADED_FOLDER+imageName);
			 if(file.delete()) {
		         return true;
		     }
		       
			 return false;
		}
				
		private Property populateProperty(PropertyDTO property,String imageURL) {
			
			Property p = new Property(property.getArea(), property.getCity(), property.getCountry(), property.getDescription(),
					imageURL, property.getLocation(),property.getName(),property.getNearBy(),property.getNoOfRooms(),property.getPrice(),property.getType());
			
			
			PropertyOwner propertyOwner = new PropertyOwner(property.getPropertyOwnerDetails().getPropertyAddress(), property.getPropertyOwnerDetails().getOwnerContact(),property.getPropertyOwnerDetails().getOwnerDemand(),property.getPropertyOwnerDetails().getOwnerName());
			
			p.setPropertyOwner(propertyOwner);
			propertyOwner.setProperty(p);
			
			return p;
		}
		
		private Property updatePropertyRecord(PropertyDTO property,String imageURL,Long id) {
			
			Property p = new Property(property.getArea(), property.getCity(), property.getCountry(), property.getDescription(),
					imageURL, property.getLocation(),property.getName(),property.getNearBy(),property.getNoOfRooms(),property.getPrice(),property.getType());
			p.setId(id);
			
			Property po = getById(id);
			
			PropertyOwner propertyOwner = new PropertyOwner(property.getPropertyOwnerDetails().getPropertyAddress(), property.getPropertyOwnerDetails().getOwnerContact(),property.getPropertyOwnerDetails().getOwnerDemand(),property.getPropertyOwnerDetails().getOwnerName());
			propertyOwner.setPropertyOwnerId(po.getPropertyOwner().getPropertyOwnerId());
			
			p.setPropertyOwner(propertyOwner);
			propertyOwner.setProperty(p);
			
			return p;
		}
		
		
		public List<Property> searchProperty(String keyword,String city,String type){
			
			List<Property> list =  propertyRepositry.findByNameContaining(keyword);
			if(city != "all" && type!="all") {
				return list.stream().filter(p->p.getCity().equalsIgnoreCase(city) && p.getType().equalsIgnoreCase(type) ).collect(Collectors.toList());
			
			}else if(city!="all") {
				return list.stream().filter(p->p.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
					
			}else if(type!="all") {
				return list.stream().filter(p->p.getType().equalsIgnoreCase(type) ).collect(Collectors.toList());
			}
			
			return list;
			
		}
}
