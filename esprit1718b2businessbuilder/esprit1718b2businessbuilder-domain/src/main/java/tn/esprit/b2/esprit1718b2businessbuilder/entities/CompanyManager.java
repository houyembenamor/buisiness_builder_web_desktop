package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.interceptor.AroundInvoke;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompanyManager
 *
 */
@Entity
@DiscriminatorValue("CompanyManager")
public class CompanyManager extends User implements Serializable {
	@OneToMany(mappedBy="companyManager")
	private List<PartnershipOffer>partnershipoffers;
	@OneToMany(mappedBy="companyManager",cascade = CascadeType.MERGE)
	private List<Event> events;

	private String companyName;
	private String companyAddress;
	private String description;
	private static final long serialVersionUID = 1L;

	public CompanyManager() {
		super();
	} 
	
	
	public CompanyManager( String firstName, String lastName, String email, String userName, String password,
			int phoneNumber,  String nationality,String companyName,String companyAddress,String description) {
		super( firstName,lastName, email, userName,  password,
		 phoneNumber,nationality);
		this.companyName=companyName;
		this.companyAddress=companyAddress;
		this.description=description;
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
	


	public CompanyManager(String companyName) {
		this.companyName = companyName;
	}


	@Override
	public String toString() {
		return "CompanyManager [companyName=" + companyName + "]";
	}


	public CompanyManager(String companyName, String companyAddress, String description) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.description = description;
	}
	
   
}
