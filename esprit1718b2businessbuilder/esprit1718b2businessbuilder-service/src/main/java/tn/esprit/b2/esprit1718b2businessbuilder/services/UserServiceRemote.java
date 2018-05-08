package tn.esprit.b2.esprit1718b2businessbuilder.services;


import javax.ejb.Remote;
import javax.naming.NamingException;


import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.utilities.IGenericDAO;


@Remote
public interface UserServiceRemote extends IGenericDAO<User> {
	public User login(String email, String password);
	public boolean isAuthentified(String email, String password) throws NamingException;
	public User login(int idUser, String password);
	public void save(User e);
	
	 User findUserById(int idUser);
	 public void addcandidatetojoboffer2(int idUser, int idOffer);
	 public User findUserByName(String firstname);
	 public User checkUserName(String login);
	 public boolean access(User u,String pw) ;
	 public boolean loginExists(String email);
}
