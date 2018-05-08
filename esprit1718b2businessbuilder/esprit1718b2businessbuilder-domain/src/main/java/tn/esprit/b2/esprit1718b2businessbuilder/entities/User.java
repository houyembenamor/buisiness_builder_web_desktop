package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;






/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_USER",discriminatorType=DiscriminatorType.STRING,length=20)
public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUser")
	private int idUser;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private int phoneNumber;
	private byte[] photo;
	private String nationality;
	@ManyToOne
	private JobOffer job;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="companyManager")
	private List <JobOffer> jobOffers;
	@ManyToOne
	private JobApplication jobapplication;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	 private Set<Comment> comments = new HashSet<Comment>(0);
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    private Set<FilDiscussion> filDiscussions = new HashSet<FilDiscussion>(0);
	


	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}   
  
	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + ", phoneNumber=" + phoneNumber + ", photo="
				+ Arrays.toString(photo) + ", nationality=" + nationality + "]";
	}
	public User( String firstName, String lastName, String email, String userName, String password,
			int phoneNumber, String nationality) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		
		this.nationality = nationality;
	}
	public JobOffer getJob() {
		return job;
	}
	public void setJob(JobOffer job) {
		this.job = job;
	}
	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}
	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}
	public JobApplication getJobapplication() {
		return jobapplication;
	}
	public void setJobapplication(JobApplication jobapplication) {
		this.jobapplication = jobapplication;
	}

	
	
   
}
