package com.hiring.portal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hiring.portal.service.IAPIService;

//@Controller
//@RequestMapping("/api")
public class filecontroller {
//	@Autowired
//	private IAPIService ls;
//
//	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
//	
//	
//	@PostMapping("/upload")
//	public String upload(@RequestParam("files") MultipartFile[] files)
//	{
//		
//		StringBuilder fileNames = new StringBuilder();
//		for(MultipartFile file : files)
//		{
//			Long maxVal = ls.findMax()+1;
//			Path fileNameAndPath = Paths.get(uploadDirectory, "input_" + maxVal + ".txt");
//		
//			fileNames.append("input_" + maxVal + ".txt");
//			try {
//				Files.write(fileNameAndPath, file.getBytes());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		System.out.println("Successfully uploaded files " + fileNames.toString());
//		System.out.println(uploadDirectory);
//		return "files uploaded";
//	}
	
}