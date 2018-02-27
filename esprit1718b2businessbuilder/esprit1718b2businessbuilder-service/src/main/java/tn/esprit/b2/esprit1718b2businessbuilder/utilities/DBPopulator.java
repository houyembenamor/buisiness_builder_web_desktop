package tn.esprit.b2.esprit1718b2businessbuilder.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	@EJB
	private UserServiceLocal userServiceLocal;

	public DBPopulator() {
	}

	@PostConstruct
	public void init() {
		//User user = new User("user", "u", "u", "user@bitbox.tn");

		//userServiceLocal.update(user);
	}
}
