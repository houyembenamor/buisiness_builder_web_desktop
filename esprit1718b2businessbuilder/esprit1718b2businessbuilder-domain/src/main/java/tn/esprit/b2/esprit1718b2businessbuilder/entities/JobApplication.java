package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobApplication
 *
 */
@Entity

public class JobApplication implements Serializable {

	   
	@Id
	@Column(name="idJobApplication")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJobApplication;
	@ManyToOne
	private User candidate;
	private String statut;

    private String positionInterested;
    private String country;
	private String typeContract;
	private String sector;
	private Date dateOfBegin;
	@OneToMany(mappedBy="jobapplication",cascade= CascadeType.MERGE,fetch=FetchType.EAGER)
	private List<User> users;
	private static final long serialVersionUID = 1L;

	public JobApplication() {
		super();
	}   
	public int getIdJobApplication() {
		return this.idJobApplication;
	}

	public JobApplication(int idJobApplication, User candidate, String statut, String positionInterested,
			String country, String typeContract, String sector, Date dateOfBegin) {
		super();
		this.idJobApplication = idJobApplication;
		this.candidate = candidate;
		this.statut = statut;
		this.positionInterested = positionInterested;
		this.country = country;
		this.typeContract = typeContract;
		this.sector = sector;
		this.dateOfBegin = dateOfBegin;
	}
	public void setIdJobApplication(int idJobApplication) {
		this.idJobApplication = idJobApplication;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getPositionInterested() {
		return positionInterested;
	}
	public void setPositionInterested(String positionInterested) {
		this.positionInterested = positionInterested;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTypeContract() {
		return typeContract;
	}
	public void setTypeContract(String typeContract) {
		this.typeContract = typeContract;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public Date getDateOfBegin() {
		return dateOfBegin;
	}
	public void setDateOfBegin(Date dateOfBegin) {
		this.dateOfBegin = dateOfBegin;
	}
	public JobApplication(int idJobApplication, Candidate candidate, String statut, String positionInterested,
			String country, String typeContract, String sector, Date dateOfBegin) {
		super();
		this.idJobApplication = idJobApplication;
		this.candidate = candidate;
		this.statut = statut;
		this.positionInterested = positionInterested;
		this.country = country;
		this.typeContract = typeContract;
		this.sector = sector;
		this.dateOfBegin = dateOfBegin;
	}
	public User getCandidate() {
		return candidate;
	}
	public void setCandidate(User candidate) {
		this.candidate = candidate;
	}
	
	public void linkUsersToThisJobApplication(List<User> users) {
		this.users= users;
		for (User e : users) {
			e.setJobapplication(this);
}
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
   
}
