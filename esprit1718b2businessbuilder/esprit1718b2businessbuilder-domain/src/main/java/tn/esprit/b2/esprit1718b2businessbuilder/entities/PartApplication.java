package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PartApplication
 *
 */
@Entity

public class PartApplication implements Serializable {
	@EmbeddedId
	private  PartApplicationPK partapplicationpk;
	private Date applicationDate;
	private static final long serialVersionUID = 1L;

	public PartApplication() {
		super();
	}   
	
	public Date getApplicationDate() {
		return this.applicationDate;
	}
	
	public PartApplicationPK getPartapplicationpk() {
		return partapplicationpk;
	}
	public void setPartapplicationpk(PartApplicationPK partapplicationpk) {
		this.partapplicationpk = partapplicationpk;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
   
}
