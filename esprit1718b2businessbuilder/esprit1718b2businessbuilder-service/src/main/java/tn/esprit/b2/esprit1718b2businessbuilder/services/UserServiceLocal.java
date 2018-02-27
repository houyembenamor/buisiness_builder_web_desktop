package tn.esprit.b2.esprit1718b2businessbuilder.services;

import javax.ejb.Local;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.utilities.IGenericDAO;

@Local
public interface UserServiceLocal extends IGenericDAO<User> {

	User login(String login, String password);

}
