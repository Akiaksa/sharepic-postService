package com.sharepic.PostService.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.sharepic.PostService.Entity.PostedContent;

@Repository
public interface PostServiceReposiotry {
	
	
	void savePostedContent(PostedContent content);
	
	

}
