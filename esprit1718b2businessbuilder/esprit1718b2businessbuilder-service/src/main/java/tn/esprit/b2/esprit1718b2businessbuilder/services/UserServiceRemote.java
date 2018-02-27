package tn.esprit.b2.esprit1718b2businessbuilder.services;

import javax.ejb.Remote;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {

}
