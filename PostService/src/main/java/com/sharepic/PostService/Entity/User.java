package com.sharepic.PostService.Entity;

import javax.persistence.*;
import java.util.*;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Integer id;

	@Column(nullable = false, length = 45, unique = true)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "full_name", nullable = false, length = 100)
	private String FullName;

	@Column(name = "profile_picture")
	private String profilePicture;

	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	@Column(name = "updated_on")
	private Date updatedOn;

	@Column(name = "profile_description", length = 300)
	private String profileDescription;
	
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String FullName) {
		this.FullName = FullName;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}
}

