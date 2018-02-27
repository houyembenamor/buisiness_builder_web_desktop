package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Application
 *
 */
@Entity

public class Application implements Serializable {
    
	@EmbeddedId
	private ApplicationPK applicationpk;
	private Date applicationDate;
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
	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
   
}
