package com.sharepic.PostService.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sharepic.PostService.util.DataBucketUtil;

import com.sharepic.PostService.Entity.PostedContent;
import com.sharepic.PostService.Entity.User;
import com.sharepic.PostService.JpaRepository.PostServiceJpaRepo;
import com.sharepic.PostService.JpaRepository.UserJpaRepository;
import com.sharepic.PostService.service.PostService;
import com.sharepic.PostService.Dto.*;

@Service
public class PostServiceImpl implements PostService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);
	
	
    @Autowired
    private  DataBucketUtil dataBucketUtil;
    
	@Autowired
	private UserJpaRepository userJpaRepo;
	
	@Autowired
	private PostServiceJpaRepo postJpaRepo;
    
    
	@Override
	public String  uploadFiles(MultipartFile file, String name) { 
		// TODO Auto-generated method stub
		
		String originalFileName = file.getOriginalFilename();
		Path path = new File(originalFileName).toPath();
		

        try {
            String contentType = Files.probeContentType(path);
            String dto = dataBucketUtil.uploadFile(file, name);
            return "";

           
        } catch (Exception e) {
            LOGGER.error("Error occurred while uploading. Error: ", e);
            return "";
           
        }
		
		
	}


	@Override
	public List<PostedContent> getPostUrl(String user_name) {
		// TODO Auto-generated method stub
		User user = userJpaRepo.findByUserName(user_name);
		int user_id = user.getId();
		List<PostedContent> post = postJpaRepo.findByUserId(user_id);
		return post;
	}

	


}
