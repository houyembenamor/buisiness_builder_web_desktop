package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Candidate
 *
 */
@Entity
@DiscriminatorValue("Candidate")
public class Candidate extends User implements Serializable {


	

	@ManyToMany
	private List<JobOffer> joboffers;
	
	private String domain;
	private String resume;
	private static final long serialVersionUID = 1L;
	
	
	


	

	

	public Candidate() {
		super();
	}   
	public Candidate( String firstName, String lastName, String email, String userName, String password,
			int phoneNumber,  String nationality,String domain) {
		super( firstName,lastName, email, userName,  password,
		 phoneNumber, nationality);
		this.domain=domain;
		
	}
	
	
	
	
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	@Override
	public String toString() {
		return "Candidate [ resume=" + resume + ", joboffers=" 
				+ ", domain=" + domain + "]";
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public List<JobOffer> getJoboffers() {
		return joboffers;
	}
	public void setJoboffers(List<JobOffer> joboffers) {
		this.joboffers = joboffers;
	}
	

   
}
