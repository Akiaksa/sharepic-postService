package com.sharepic.PostService.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.sharepic.PostService.Dto.FileDto;
import com.sharepic.PostService.Entity.PostedContent;

import com.sharepic.PostService.service.PostService;

@RestController
@RequestMapping("/sharepic")
public class PostController {
	
	@Autowired
	private Storage storage;
	
	//@Autowired
	//private FileRepository repo;
	
	@GetMapping("/post")
	public String postContent() throws IOException
	{
		StringBuilder sb = new StringBuilder();
		sb.append("https://storage.cloud.google.com/sharepic_files/");
		sb.append("Avi.jpg");
		BlobId id =BlobId.of("sharepic_files", "Avi.jpg");
		BlobInfo info = BlobInfo.newBuilder(id).build();
		File file = new File("C:/Users/002LSO744/Pictures" , "Avi.jpg");
		byte[] arr=Files.readAllBytes(Paths.get(file.toURI()));
		storage.create(info, arr);
		
		//storage.delete(id);
		
		
		
		return "Hello"  + "  " + Paths.get(file.toURI()) + "  " + sb + "  " + info.getContentType() + "   " + id.toGsUtilUri();
	}
	
private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    
    @Autowired
    private  PostService postService;
    
   
    /*
	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE} )
	@RequestMapping("/post1")
	public FileDto addFile(@RequestParam("files")MultipartFile files){
		System.out.println("HEre");
        LOGGER.debug("Call addFile API");
        System.out.println("calling method");
        return postService.uploadFiles(files);
    }
	*/
	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE} )
	@RequestMapping("/postFile")
	public String greeting(@RequestHeader(name = "user_name") String name, @RequestParam("files")MultipartFile files) {
	    // code that uses the language variable
		String dto = postService.uploadFiles(files, name);
	    return name;
	}
	
	
	
	@GetMapping("/showData")
	public List<PostedContent> getFiles(@RequestHeader(name = "user_name")String name){
	    // code that uses the language variable
		//String dto = postService.uploadFiles(files, name);
		List <PostedContent> postData =postService.getPostUrl(name);
		
		
		return postData;
	    
	}
	

	@GetMapping("/greet")
	public String greet(){
	    return "Hello User";
	    
	}

}
