package com.sharepic.PostService.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharepic.PostService.Entity.PostedContent;
import java.util.List;


@Repository
public interface PostServiceJpaRepo extends JpaRepository<PostedContent, Integer> {
	
	@Query ("SELECT p FROM PostedContent p WHERE p.user_id= ?1")
	List<PostedContent> findByUserId(int user_id);

}
