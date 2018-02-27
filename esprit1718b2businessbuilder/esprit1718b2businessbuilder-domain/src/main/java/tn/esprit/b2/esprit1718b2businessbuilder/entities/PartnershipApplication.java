package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PartnershipApplication
 *
 */
@Entity

public class PartnershipApplication implements Serializable {

	   
	@Id
	private int idPartnershipApplication;
	@ManyToOne
	private PartnerResearcher partnerResearcher;
	private String title;
	private String description;
	private Date dateOfApplication;
	private static final long serialVersionUID = 1L;

	public PartnershipApplication() {
		super();
	}   
	public int getIdPartnershipApplication() {
		return this.idPartnershipApplication;
	}

	public void setIdPartnershipApplication(int idPartnershipApplication) {
		this.idPartnershipApplication = idPartnershipApplication;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getDateOfApplication() {
		return this.dateOfApplication;
	}

	public void setDateOfApplication(Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}
   
}
