package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Feedback
 *
 */
@Entity

public class Feedback implements Serializable {

	   
	@Id
	private int idFeedback;
	private String title;
	private String content;
	private Date dateOfPost;
	private String type;
	private static final long serialVersionUID = 1L;

	public Feedback() {
		super();
	}   
	public int getIdFeedback() {
		return this.idFeedback;
	}

	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public Date getDateOfPost() {
		return this.dateOfPost;
	}

	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
