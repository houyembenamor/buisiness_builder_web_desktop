package tn.esprit.b2.esprit1718b2businessbuilder.mBeans;


import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;


import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceLocal;

@ManagedBean

@ViewScoped
public class userBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal userServiceLocal;

	private User user;
	private List<User>users;
	private boolean showForm;
	

	
	@PostConstruct
	private void init() {
		user=new User();
		users=userServiceLocal.findAll();
		showForm = false;
	
	
	}
	public void doSelect() {
		showForm = true;
	}

	public void doCancel() {
		showForm = false;
	}
	public String doAddUser() {
		this.userServiceLocal.update(this.user);
		this.user=new User();
		//showForm = false;
         return"";
	}

	public String doDeleteJobOffer() {
		userServiceLocal.delete(user);
		users = userServiceLocal.findAll();
		showForm = false;
		return "";
	}
	
	public boolean isShowForm() {
		return showForm;
	}
	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}
	public UserServiceLocal getUserServiceLocal() {
		return userServiceLocal;
	}
	public void setUserServiceLocal(UserServiceLocal userServiceLocal) {
		this.userServiceLocal = userServiceLocal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
}
