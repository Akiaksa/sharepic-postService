/*package com.sharepic.PostService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "post_comments")
public class PostComments {
	
	@ManyToOne
	@JoinColumn (name = "post_id" )
	private PostedContent id;
	
	@ManyToOne
	@JoinColumn (name = "user_id" )
	private User userCom;
	
	@Column(name= "comment" , length = 300)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "post_id" )
	private PostedContent content;

	public PostedContent getId() {
		return id;
	}

	public void setId(PostedContent id) {
		this.id = id;
	}

	public User getuserCom() {
		return userCom;
	}

	public void setuserCom(User user) {
		this.userCom = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	

}
*/