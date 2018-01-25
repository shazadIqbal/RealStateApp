package com.realstate.realstate.controller;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/property")	
public class PropertyController {
	
	//@Value("${path}")
	private static String UPLOADED_FOLDER="C://serverfiles//";
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public String addItem(@RequestBody MultipartFile file) {
		
		  try {
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
  
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "File Saved";	
       
    }
	
	
	@RequestMapping(value = "/{filename:.+}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getImage(@PathVariable("filename") String filename)
	        throws IOException {
		
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
