package com.sharepic.PostService.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharepic.PostService.Entity.PostedContent;
import com.sharepic.PostService.JpaRepository.PostServiceJpaRepo;
import com.sharepic.PostService.repository.PostServiceReposiotry;

@Repository
public class PostServiceRepositoryImpl implements PostServiceReposiotry  {

	@Autowired
	private PostServiceJpaRepo repo;
	
	@Override
	public void savePostedContent(PostedContent content) {
		// TODO Auto-generated method stub
		try {
			repo.save(content);
		}
		catch(Exception e)
		{
			System.out.println("exception   " + e);
		}
		
	}
	
	

}
