package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompanyManager
 *
 */
@Entity

public class CompanyManager extends User implements Serializable {
	@OneToMany(mappedBy="companyManager")
	private List<PartnershipOffer>partnershipoffers;
	@OneToMany(mappedBy="companyManager")
	private List<Event> events;
	@OneToMany(mappedBy="companyManager")
	private List <JobOffer> jobOffers;
	private String companyName;
	private String companyAddress;
	private String description;
	private static final long serialVersionUID = 1L;

	public CompanyManager() {
		super();
	}   
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}   
	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public List<PartnershipOffer> getPartnershipoffers() {
		return partnershipoffers;
	}
	public void setPartnershipoffers(List<PartnershipOffer> partnershipoffers) {
		this.partnershipoffers = partnershipoffers;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}
	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}
	
   
}
