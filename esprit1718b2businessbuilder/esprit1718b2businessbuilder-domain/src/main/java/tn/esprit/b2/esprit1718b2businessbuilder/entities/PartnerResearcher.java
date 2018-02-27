package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PartnerResearcher
 *
 */
@Entity

public class PartnerResearcher extends User implements Serializable {

	@ManyToMany(mappedBy="partnerResearchers")
	private List <Event> events;
	@ManyToMany
	private List <PartnershipOffer>partnerShipOffers;
	@OneToMany(mappedBy="partnerResearcher")
	private List<PartnershipApplication>partnershipApplications;
	private String partnerResearcherType;
	private String description;
	private String organismName;
	private static final long serialVersionUID = 1L;

	public PartnerResearcher() {
		super();
	}   
	public String getPartnerResearcherType() {
		return this.partnerResearcherType;
	}

	public void setPartnerResearcherType(String partnerResearcherType) {
		this.partnerResearcherType = partnerResearcherType;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getOrganismName() {
		return this.organismName;
	}

	public void setOrganismName(String organismName) {
		this.organismName = organismName;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public List<PartnershipOffer> getPartnerShipOffers() {
		return partnerShipOffers;
	}
	public void setPartnerShipOffers(List<PartnershipOffer> partnerShipOffers) {
		this.partnerShipOffers = partnerShipOffers;
	}
	
}
