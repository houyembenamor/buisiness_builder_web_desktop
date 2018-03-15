package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	  
	@Id
	@Column(name="idEvent")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvent;
	@ManyToMany
	private List <PartnerResearcher> partnerResearchers;
	@ManyToOne
	private CompanyManager companyManager;
	private String title;
	private Date postDate;
	private String description;
	private Date dateEvent;
	private String photo;
	private int capacity;
	private String lieu;
	public CompanyManager getCompanyManager() {
		return companyManager;
	}
	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}   
	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
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
	public Date getDateEvent() {
		return this.dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}   
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}   
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<PartnerResearcher> getPartnerResearchers() {
		return partnerResearchers;
	}
	public void setPartnerResearchers(List<PartnerResearcher> partnerResearchers) {
		this.partnerResearchers = partnerResearchers;
	}
   
}
