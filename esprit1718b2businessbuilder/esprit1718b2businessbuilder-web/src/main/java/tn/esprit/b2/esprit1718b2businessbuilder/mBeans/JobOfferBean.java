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


import tn.benamor.businessbuilder.services.JobOfferServiceLocal;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceLocal;

@ManagedBean(name="JobOfferBean")

@ViewScoped
public class JobOfferBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private JobOfferServiceLocal jobofferServiceLocal;
	@EJB
	private UserServiceLocal userServiceLocal;
	@ManagedProperty("#{autentificationBean}")
	private autentificationBean authBean;
	private JobOffer joboffer;
	private List<JobOffer>joboffers;
	private boolean showForm;
	private List<User>users;
	private User  companyManager;
	private int idOfuser;
	private List<SelectItem> list;
	
	@PostConstruct
	private void init() {
		joboffer=new JobOffer();
		joboffers=jobofferServiceLocal.findAll();
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
	public String doAddJobOffer() {
		/*this.jobofferServiceLocal.update(this.joboffer);
		this.joboffer=new JobOffer();
		//showForm = false;
         return"";*/
  //  joboffer.setCompanyManager(companyManager);
         this.jobofferServiceLocal.update(this.joboffer);
        
       
         return"jobs?faces-redirect=true";
	}


	public String doDeleteJobOffer() {
		this.jobofferServiceLocal.remove(this.joboffer);
		//setJoboffers( jobofferServiceLocal.findAll());
		setShowForm( false);
		return"jobs?faces-redirect=true";
	
	
		
	}
	public JobOffer getJoboffer() {
		return joboffer;
	}
	public void setJoboffer(JobOffer joboffer) {
		this.joboffer = joboffer;
	}
	public List<JobOffer> getJoboffers() {
		return joboffers;
	}
	public void setJoboffers(List<JobOffer> joboffers) {
		this.joboffers = joboffers;
	}
	public boolean isShowForm() {
		return showForm;
	}
	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}
	public autentificationBean getAuthBean() {
		return authBean;
	}
	public void setAuthBean(autentificationBean authBean) {
		this.authBean = authBean;
	}
	public User getCompanyManager() {
		return companyManager;
	}
	public void setCompanyManager(User companyManager) {
		this.companyManager = companyManager;
	}
	
	public void dolinkusertojoboffer() {
		if (idOfuser != 0) {
			List<User> equipements = new ArrayList<>();
			equipements.add(userServiceLocal.find(idOfuser));
			joboffer.linkUsersToThisJobOffer(equipements);
			jobofferServiceLocal.update(joboffer);
		} else {
			jobofferServiceLocal.update(joboffer);
		}

		showForm = false;
		System.out.println("affectation");

	}
	public JobOfferServiceLocal getJobofferServiceLocal() {
		return jobofferServiceLocal;
	}
	public void setJobofferServiceLocal(JobOfferServiceLocal jobofferServiceLocal) {
		this.jobofferServiceLocal = jobofferServiceLocal;
	}
	public UserServiceLocal getUserServiceLocal() {
		return userServiceLocal;
	}
	public void setUserServiceLocal(UserServiceLocal userServiceLocal) {
		this.userServiceLocal = userServiceLocal;
	}
	public int getIdOfuser() {
		return idOfuser;
	}
	public void setIdOfuser(int idOfuser) {
		this.idOfuser = idOfuser;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<SelectItem> getList() {
		return list;
	}
	public void setList(List<SelectItem> list) {
		this.list = list;
	}
	
}
