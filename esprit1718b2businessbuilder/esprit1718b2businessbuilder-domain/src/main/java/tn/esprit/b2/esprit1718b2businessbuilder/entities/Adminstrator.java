package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adminstrator
 *
 */
@Entity

public class Adminstrator extends User implements Serializable {

	
	private String category;
	private static final long serialVersionUID = 1L;

	public Adminstrator() {
		super();
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
   
}
