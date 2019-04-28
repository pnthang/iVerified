package ca.gtem.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(path = "/api")
public class FileUpload {
	public static final String uploadingDir = System.getProperty("user.dir") + "/files/tmp/";
	
	@PostMapping("/upload")
	public String uploadingPost(@RequestParam("uploadingFile") MultipartFile uploadingFile) throws IOException {        
       File file = new File(uploadingDir + uploadingFile.getOriginalFilename());
       uploadingFile.transferTo(file);        
       return file.getName();
    }
}
