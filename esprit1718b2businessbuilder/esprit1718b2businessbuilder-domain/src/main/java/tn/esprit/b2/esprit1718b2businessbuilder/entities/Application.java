package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;


import javax.persistence.*;
import javax.persistence.JoinColumn;
/**
 * Entity implementation class for Entity: Application
 *
 */
@Entity

public class Application implements Serializable {
    
	@EmbeddedId
	private ApplicationPK applicationpk;
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", updatable = false, insertable = false)
	private Candidate candidate;
	@ManyToOne
	@JoinColumn(name = "idOffer", referencedColumnName = "idOffer", updatable = false, insertable = false)
	private JobOffer joboffer;
	private static final long serialVersionUID = 1L;

	public Application() {
		super();
	}
	
	public ApplicationPK getApplicationpk() {
		return applicationpk;
	}
	public void setApplicationpk(ApplicationPK applicationpk) {
		this.applicationpk = applicationpk;
	}
	
   
}
