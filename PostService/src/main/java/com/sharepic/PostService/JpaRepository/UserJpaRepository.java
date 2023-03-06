package com.sharepic.PostService.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sharepic.PostService.Entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
	
	//search user with username
		@Query ("SELECT u FROM User u WHERE u.password= ?1")
		User findByUserName(String userName);

}
