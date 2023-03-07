package com.sharepic.PostService.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.sharepic.PostService.Dto.FileDto;

import com.sharepic.PostService.Entity.PostedContent;
import com.sharepic.PostService.Entity.User;

@Component
public class PostedContentMapper {
	
	public PostedContent mapDtoToEntity(FileDto file , User user )
	{
		PostedContent obj = new PostedContent();
		obj.setContentType(file.getContentType());
		obj.setLikes(null);
		obj.setPath(file.getFileUrl());
		obj.setPostedDate(new Date());
		obj.setPostName(file.getFileName());
		obj.setUser_id(user.getId());
		obj.setFirebase_uid(user.getPassword());
		obj.setLikes(0);
		
		return obj;
		
	}

}
