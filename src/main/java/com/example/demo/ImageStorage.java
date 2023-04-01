package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/image")
public class ImageStorage {
	@Autowired
	private FirebaseImage firebase;
	
	@PostMapping("/UploadImage")
	public   String GetImage(@RequestParam(value = "file") MultipartFile multipartFile){
		return firebase.GetImage(multipartFile);
	}
	@PostMapping("/DeleteImage")
	public   String DeleteImage(@RequestParam(value = "fileName") String fileName) throws IOException {
		return firebase.DeleteImage(fileName);
	}

}
