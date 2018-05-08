package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name = "idUser",referencedColumnName="idUser")
	private User companyManager;
	
	//@ManyToMany(mappedBy="joboffers")
	@OneToMany(mappedBy="job",cascade= CascadeType.MERGE,fetch=FetchType.EAGER)
	private List<User> users;
	//@OneToMany(mappedBy="job",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	@ManyToMany(mappedBy="joboffers")
	private List<Candidate> candidates;
	private String title;
	private Date postDate;
	private String sector;
	private String studyLevel;
	private String country;
	private String experience;
	private String skills;
	private  String jobPreferences;
	private int star;
	
	  @OneToMany(fetch=FetchType.EAGER, mappedBy="category")
	     private Set<FilDiscussion> filDiscussions = new HashSet<FilDiscussion>(0);
	
	
	public Set<FilDiscussion> getFilDiscussions() {
		return filDiscussions;
	}
	public void setFilDiscussions(Set<FilDiscussion> filDiscussions) {
		this.filDiscussions = filDiscussions;
	}
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
	
	public JobOffer(String title, Date postDate, String sector, String studyLevel, String country, String experience,
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
		return postDate;
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
	
	  
	

	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public JobOffer( String title, String sector) {
		super();
	
		this.title = title;
		this.sector = sector;
	}
	public void linkUsersToThisJobOffer(List<User> users) {
		this.users= users;
		for (User e : users) {
			e.setJob(this);
}
	}
	public List<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	public User getCompanyManager() {
		return companyManager;
	}
	public void setCompanyManager(User companyManager) {
		this.companyManager = companyManager;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	

	}

