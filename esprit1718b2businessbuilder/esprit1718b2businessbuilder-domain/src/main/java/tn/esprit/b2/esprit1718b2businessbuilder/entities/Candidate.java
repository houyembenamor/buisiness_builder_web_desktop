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

public class Candidate extends User implements Serializable {

	@OneToMany(mappedBy="candidate")
	private List<jobApplication>jobApplications;
	@OneToOne(mappedBy="candidate")
	private Resume resume;
	@ManyToMany
	private List<JobOffer> joboffers;
	public List<jobApplication> getJobApplications() {
		return jobApplications;
	}
	public void setJobApplications(List<jobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public List<JobOffer> getJoboffers() {
		return joboffers;
	}
	public void setJoboffers(List<JobOffer> joboffers) {
		this.joboffers = joboffers;
	}

	private String domain;
	private static final long serialVersionUID = 1L;

	public Candidate() {
		super();
	}   
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
   
}
