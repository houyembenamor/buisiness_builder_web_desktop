package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobOffer
 *
 */
@Entity

public class JobOffer implements Serializable {

	   
	@Id
	@Column(name="idOffer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOffer;
	@ManyToOne
	private CompanyManager companyManager;
	@ManyToMany(mappedBy="joboffers")
	private List<Candidate> candidates;
	private String title;
	private Date postDate;
	private String sector;
	private String studyLevel;
	private String country;
	private Float experience;
	private String skills;
	private  String jobPreferences;
	public String getJobPreferences() {
		return jobPreferences;
	}
	public void setJobPreferences(String jobPreferences) {
		this.jobPreferences = jobPreferences;
	}

	private static final long serialVersionUID = 1L;

	public JobOffer() {
		super();
	}   
	
	public JobOffer(String title, Date postDate, String sector, String studyLevel, String country, Float experience,
			String skills, String jobPreferences) {
		super();
		this.title = title;
		this.postDate = postDate;
		this.sector = sector;
		this.studyLevel = studyLevel;
		this.country = country;
		this.experience = experience;
		this.skills = skills;
		this.jobPreferences = jobPreferences;
	}
	public int getIdOffer() {
		return this.idOffer;
	}

	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
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
	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}   
	public String getStudyLevel() {
		return this.studyLevel;
	}

	public void setStudyLevel(String studyLevel) {
		this.studyLevel = studyLevel;
	}   
	

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	  
	public float getExperience() {
		return this.experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}   
	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	public CompanyManager getCompanyManager() {
		return companyManager;
	}
	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}
   
}
