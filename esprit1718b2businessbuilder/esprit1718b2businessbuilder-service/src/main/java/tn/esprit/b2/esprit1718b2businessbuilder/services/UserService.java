package tn.esprit.b2.esprit1718b2businessbuilder.services;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import tn.benamor.buisinessbuilder.services.candidate.CandidateServiceRemote;
import tn.benamor.businessbuilder.services.JobOfferServiceLocal;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Application;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.utilities.GenericDAO;

/**
 * Session Bean implementation class UserService
 * @param <T>
 */
@Stateless
public class UserService extends GenericDAO<User> implements UserServiceRemote, UserServiceLocal {
	@PersistenceContext
	private EntityManager em;
	
	
	@EJB
	private JobOfferServiceLocal service;
	@EJB
	private UserServiceLocal service1;
	Candidate admin;

	/**
	 * Default constructor.
	 */
	public UserService() {
		super(User.class);
	}

	@Override
	public User login(String email, String password) {
		User user = null;
		try {
			user = em.createQuery("SELECT u FROM User u WHERE u.email=:l AND u.password=:p", User.class)
					.setParameter("l", email).setParameter("p", password).getSingleResult();
		} catch (Exception e) {
		}
		return user;
	}

	@EJB
	private CandidateServiceRemote as ;
	
	@Override
	public boolean isAuthentified(String email, String password) throws NamingException {
		this.admin = new Candidate();
		admin.setEmail(email);
		admin.setPassword(password);
		System.out.println("****"+admin.getEmail());
		System.out.println("****"+admin.getPassword());

		boolean auth = false;
		
		System.out.println("get list************");
		List<Candidate> admins = as.findAll();
		System.out.println("list OKKKKKK");
		for (Candidate p : admins) {

			if (admin.getEmail().equals(p.getEmail())) {
				if (admin.getPassword().equals(p.getPassword())) {
					auth = true;
					System.out.println("auth");
					break;
				}
				System.out.println(" NONauth");
			}
			System.out.println("list");
		}

		return auth;
	}

	@Override
	public User login(int idUser, String password) {
		User user = null;
		try {
			user = em.createQuery("SELECT u FROM User u WHERE u.idUser=:l AND u.password=:p", User.class)
					.setParameter("l", idUser).setParameter("p", password).getSingleResult();
		} catch (Exception e) {
		}
		return user;
	}



@Override
	public void save(User e) {
		em.persist(e);
		}
		
	

	@Override
	public User findUserById(int idUser) {
		return em.find(User.class, idUser);
	}
	@Override
	public void addcandidatetojoboffer2(int idUser, int idOffer) {
		User c=service1.findUserById(idUser);
		JobOffer j=service.findJobOfferById(idOffer);
		Application application=new Application(c,j);
		em.merge(application);
		
	}

	@Override
	public User findUserByName(String firstname) {
		return em.find(User.class, firstname);
	}
	@Override
	public User checkUserName(String email) {
		Query q = em.createQuery("select c from User c where c.email =:pane",User.class).setParameter("pane", email);
		if(q.getResultList().isEmpty())
			return null;
		else
			return (User) q.getSingleResult();
		
		
		
	}
	
	
	@Override
	public boolean access(User u,String pw) {
		if(u==null)
			return false;
		else{
			if(u.getPassword().equals(pw))
				return true;
			return false;
				
		}
	}
	@Override
	public boolean loginExists(String email) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from User u where u.email=:email";
		TypedQuery<Boolean> query = em.createQuery(jpql, Boolean.class);
		query.setParameter("email", email);
		try {
			exists = query.getSingleResult();
		} catch (NoResultException e) {
			Logger.getLogger(UserService.class.getName()).log(
					Level.WARNING, "no user registred with login=" + email);
		}
		return exists;
	}

}
