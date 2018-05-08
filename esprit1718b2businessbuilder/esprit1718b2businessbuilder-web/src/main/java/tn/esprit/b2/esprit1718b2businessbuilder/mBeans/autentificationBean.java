package tn.esprit.b2.esprit1718b2businessbuilder.mBeans;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;



import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceLocal;


@ManagedBean

@SessionScoped
public class autentificationBean  {

	@EJB
	private UserServiceLocal authenticationServiceLocal;

	private User user = new User();
	private boolean loggedIn;
	private boolean logged = false;
private String email;
private String password;












	public String login() {
		User u1 = authenticationServiceLocal.login(user.getEmail(),user.getPassword());
		if (u1 != null) {
			//if (authenticationServiceLocal.access(u1, user.getPassword())) {
				//user = profileJPARemote.fill(u1);
				logged = true;
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
				//return "index";
			
		}
		else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or Password is invalid"));
        }
		return "index";

	}

	public String doLogin(){
		User u1=authenticationServiceLocal.login(user.getEmail(), user.getPassword());
		if(u1!=null){
			user=u1;
			loggedIn=true;
			return "index?faces-redirect=true";
			
		}
		FacesMessage msg= new FacesMessage("bad Credentials");
		//	FacesContext.getCurrentInstance().addMessage("form_login:connect", msg);
		
		return "register";
	}
	
	
	@PostConstruct
	public void initModel() {
		user = new User();
		loggedIn = false;
		logged = false;
	}	
	public String dologed() {
	User u=	this.authenticationServiceLocal.login(this.user.getEmail(),this.user.getPassword());
	if(u!=null){
		u=this.user=new User();
		
		logged=true;
		
	}
		//showForm = false;
         return"index";
	}


	public String doLogout() {

		  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("username");
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        user=null;
	        return "index.xhtml?faces-redirect=true";
	}
	
	
	
	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public void refresh(){
		//user=profileJPARemote.fill(user);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().replace("user", user);
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
}
