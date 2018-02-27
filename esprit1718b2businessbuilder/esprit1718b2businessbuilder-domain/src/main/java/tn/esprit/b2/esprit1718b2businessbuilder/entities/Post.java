package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity

public class Post implements Serializable {

	   
	@Id
	private int idPost;
	private String title;
	private Date postDate;
	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	}   
	public int getIdPost() {
		return this.idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
   
}
