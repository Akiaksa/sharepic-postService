package com.sharepic.PostService.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sharepic.PostService.Entity.PostedContent;
import com.sharepic.PostService.Dto.*;

@Service
public interface PostService {
	
	String uploadFiles(MultipartFile files, String name);
	
	List<PostedContent> getPostUrl(String user_name);
	
	

}
