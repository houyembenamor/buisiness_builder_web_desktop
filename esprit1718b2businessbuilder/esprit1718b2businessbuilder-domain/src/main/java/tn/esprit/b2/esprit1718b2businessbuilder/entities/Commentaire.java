package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Commentaire
 *
 */
@Entity

public class Commentaire implements Serializable {

	   
	@Id
	private int idComment;
	private String content;
	private static final long serialVersionUID = 1L;

	public Commentaire() {
		super();
	}   
	public int getIdComment() {
		return this.idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
   
}
