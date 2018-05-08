package tn.esprit.b2.esprit1718b2businessbuilder.mBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceLocal;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobApplication;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceLocal;

@ManagedBean(name="JobApplicationBean")

@ViewScoped
public class JobApplicationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private JobApplicationServiceLocal jobapplicationServiceLocal;
	@EJB
	private UserServiceLocal userServiceLocal;
	@ManagedProperty("#{autentificationBean}")
	private autentificationBean authBean;
	private JobApplication jobapplication;
	private List<JobApplication>jobapplications;
	private boolean showForm;
	private List<User>users;
	private User  companyManager;
	private int idOfuser;
	private List<SelectItem> list;
	public JobApplicationServiceLocal getJobapplicationServiceLocal() {
		return jobapplicationServiceLocal;
	}
	public void setJobapplicationServiceLocal(JobApplicationServiceLocal jobapplicationServiceLocal) {
		this.jobapplicationServiceLocal = jobapplicationServiceLocal;
	}
	public UserServiceLocal getUserServiceLocal() {
		return userServiceLocal;
	}
	public void setUserServiceLocal(UserServiceLocal userServiceLocal) {
		this.userServiceLocal = userServiceLocal;
	}
	public autentificationBean getAuthBean() {
		return authBean;
	}
	public void setAuthBean(autentificationBean authBean) {
		this.authBean = authBean;
	}
	public JobApplication getJobapplication() {
		return jobapplication;
	}
	public void setJobapplication(JobApplication jobapplication) {
		this.jobapplication = jobapplication;
	}
	public List<JobApplication> getJobapplications() {
		return jobapplications;
	}
	public void setJobapplications(List<JobApplication> jobapplications) {
		this.jobapplications = jobapplications;
	}
	public boolean isShowForm() {
		return showForm;
	}
	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getCompanyManager() {
		return companyManager;
	}
	public void setCompanyManager(User companyManager) {
		this.companyManager = companyManager;
	}
	public int getIdOfuser() {
		return idOfuser;
	}
	public void setIdOfuser(int idOfuser) {
		this.idOfuser = idOfuser;
	}
	public List<SelectItem> getList() {
		return list;
	}
	public void setList(List<SelectItem> list) {
		this.list = list;
	}
	@PostConstruct
	private void init() {
		jobapplication=new JobApplication();
		jobapplications=jobapplicationServiceLocal.findAll();
		showForm = false;
		companyManager=authBean.getUser();
		users=userServiceLocal.findAll();
		 list=new ArrayList<>();
		for (User user : users) {
			list.add(new SelectItem(user.getIdUser(), user.getUserName()));
		}
	
	}
	
	public void doSelect() {
		showForm = true;
	}

	public void doCancel() {
		showForm = false;
	}
	public String doAddJobApplication() {
		/*this.jobofferServiceLocal.update(this.joboffer);
		this.joboffer=new JobOffer();
		//showForm = false;
         return"";*/
         jobapplication.setCandidate(companyManager);
         this.jobapplicationServiceLocal.update(this.jobapplication);
         return"";
	}


	public String doDeleteJobApplication() {
		this.jobapplicationServiceLocal.remove(this.jobapplication);
	
		setShowForm( false);
		return "";
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
