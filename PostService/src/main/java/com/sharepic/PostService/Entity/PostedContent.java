package com.sharepic.PostService.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
public class PostedContent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id" )
	private Integer id;
	
	@Column(name = "user_id" )
	private int user_id;
	
	@Column(name = "uid" )
	private String firebase_uid ;
	
	@Column(name = "content_type" ,  nullable = false, length = 100 )
	private String contentType;
	
	
	@Column(name = "post_name")
	private String postName;
	
	@Column(name = "gs_path")
	private String path;
	
	@Column(name= "post_date")
	private Date postedDate;
	
	@Column (name= "post_likes")
	private Integer likes;

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirebase_uid() {
		return firebase_uid;
	}

	public void setFirebase_uid(String firebase_uid) {
		this.firebase_uid = firebase_uid;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
	

}
