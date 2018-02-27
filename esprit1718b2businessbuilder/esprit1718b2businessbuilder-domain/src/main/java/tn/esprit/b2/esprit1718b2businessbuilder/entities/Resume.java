package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Resume
 *
 */
@Entity

public class Resume implements Serializable {

	   
	@Id
	private int idResume;
	@OneToOne
	private Candidate candidate;
	private String Skills;
	private String leisure;
	private String school;
	private String degree;
	private String fildOfStudy;
	private Date beginigDate;
	private Date finishingDate;
	private String city;
	private String experience;
	private String period;
	private static final long serialVersionUID = 1L;

	public Resume() {
		super();
	}   
	public int getIdResume() {
		return this.idResume;
	}

	public void setIdResume(int idResume) {
		this.idResume = idResume;
	}   
	public String getSkills() {
		return this.Skills;
	}

	public void setSkills(String Skills) {
		this.Skills = Skills;
	}   
	public String getLeisure() {
		return this.leisure;
	}

	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getFildOfStudy() {
		return fildOfStudy;
	}
	public void setFildOfStudy(String fildOfStudy) {
		this.fildOfStudy = fildOfStudy;
	}
	public Date getBeginigDate() {
		return beginigDate;
	}
	public void setBeginigDate(Date beginigDate) {
		this.beginigDate = beginigDate;
	}
	public Date getFinishingDate() {
		return finishingDate;
	}
	public void setFinishingDate(Date finishingDate) {
		this.finishingDate = finishingDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public void setLeisure(String leisure) {
		this.leisure = leisure;
	}
   
}
