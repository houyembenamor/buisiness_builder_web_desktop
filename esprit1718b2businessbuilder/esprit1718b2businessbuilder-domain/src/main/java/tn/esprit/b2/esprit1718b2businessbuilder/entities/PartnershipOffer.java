package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PartnershipOffer
 *
 */
@Entity

public class PartnershipOffer implements Serializable {

	  
	
	 @Id
	private int idPartnershipOffer;
	
	@ManyToOne
	private CompanyManager companyManager;
	@ManyToMany(mappedBy="partnerShipOffers")
	private List <PartnerResearcher> partnerResearchers;
	private String title;
	private Date postDate;
	private String description;
	private String goal;
	private String partnerShipDomain;
	private String PartnershipPreferences;
	private static final long serialVersionUID = 1L;

	public PartnershipOffer() {
		super();
	}   
	public int getIdPartnershipOffer() {
		return this.idPartnershipOffer;
	}

	public void setIdPartnershipOffer(int idPartnershipOffer) {
		this.idPartnershipOffer = idPartnershipOffer;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}   
	public String getPartnerShipDomain() {
		return this.partnerShipDomain;
	}

	public void setPartnerShipDomain(String partnerShipDomain) {
		this.partnerShipDomain = partnerShipDomain;
	}   
	public String getPartnershipPreferences() {
		return this.PartnershipPreferences;
	}

	public void setPartnershipPreferences(String PartnershipPreferences) {
		this.PartnershipPreferences = PartnershipPreferences;
	}
	
	public CompanyManager getCompanyManager() {
		return companyManager;
	}
	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}
	public List<PartnerResearcher> getPartnerResearchers() {
		return partnerResearchers;
	}
	public void setPartnerResearchers(List<PartnerResearcher> partnerResearchers) {
		this.partnerResearchers = partnerResearchers;
	}
	
   
}
