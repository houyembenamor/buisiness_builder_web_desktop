package tn.esprit.b2.esprit1718b2businessbuilder.mBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceLocal;

@ManagedBean(name="registerBean")
@ViewScoped
public class registerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserServiceLocal userservice;
	@ManagedProperty("#{autentificationBean}")
	private autentificationBean authBean;
	private User user;
	private List<User> users;
	private int companyManager;
	private Part photo;
	@PostConstruct
	public void init() {
		
		user = new User();
		users=userservice.findAll();
		
	}

	public String doSignUp() {
	

		String navigateTo = "";
		userservice.update(user);
		authBean.setUser(user);
		navigateTo = authBean.doLogin();
		return navigateTo;
	}
	public UserServiceLocal getUserservice() {
		return userservice;
	}
	public void setUserservice(UserServiceLocal userservice) {
		this.userservice = userservice;
	}
	public autentificationBean getAuthBean() {
		return authBean;
	}
	public void setAuthBean(autentificationBean authBean) {
		this.authBean = authBean;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void validateLoginUnicity(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String loginToValidate = (String) value;
		if (loginToValidate == null || loginToValidate.trim().isEmpty()) {
			return;
		}
		boolean loginInUse = userservice.loginExists(loginToValidate);
		if (loginInUse) {
			throw new ValidatorException(new FacesMessage(
					"login already in use!"));
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@SuppressWarnings("unchecked")
	public String doAllusers() {
		this.userservice.findAll();
		this.users=(List<User>) new User();
		//showForm = false;
         return"";
	}

	public int getCompanyManager() {
		return companyManager;
	}

	public void setCompanyManager(int companyManager) {
		this.companyManager = companyManager;
	}
	
}
