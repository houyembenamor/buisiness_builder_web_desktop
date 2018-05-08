package tn.benamor.buisinessbuilder.services.candidate;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Application;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;



/**
 * Session Bean implementation class CandidateService
 */
@Stateless
public class CandidateService  implements CandidateServiceRemote, CandidateServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public CandidateService() {
    	
    }
	@Override
	public void add(Candidate e) {
			em.persist(e);
		
		
	}
	@Override
	public List<Candidate> findAll() {
		return em.createQuery("select e from Candidate e",Candidate.class).getResultList();
	}
	@Override
	public void update(Candidate e) {
		em.merge(e);
		
	}
	@Override
	public void remove(Candidate e) {
		em.remove(em.merge(e));
		
	}
	
	@Override
	public Candidate findCandidateById(int idUser) {
		return em.find(Candidate.class, idUser);
	}
	
	
	
	@Override
	public boolean updateCandidate(int idUser, String firstName, String lastName, String email, String userName,
			String password, int phoneNumber, String nationality, String domain) {
	
		Candidate std;
		try {
			std=findCandidateById(idUser);
		std.setFirstName(firstName);
			std.setLastName(lastName);
			std.setEmail(email);
		  std.setUserName(userName);
		  std.setPassword(password);
		  std.setPhoneNumber(phoneNumber);
		  std.setNationality(nationality);
		  std.setDomain(domain);
		  
		  
			em.merge(std);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
	}

	@Override
	public Boolean addPhoto(Candidate c, byte[] photo) {
		Candidate std=null;
		std = c;
		try {
			std.setPhoto(photo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Candidate findCandidateByEmail(String email) {
		return em.find(Candidate.class, email);
	}
	@Override
	public void addcandidatetojoboffer(int idUser, int idOffer) {
		Candidate c=em.find(Candidate.class, idUser);
		JobOffer j=em.find(JobOffer.class, idOffer);
		c.getJoboffers().add(j);
		j.getCandidates().add(c);
	}
	@Override
	public void addcandidatetojoboffer2(int idUser, int idOffer) {
		Candidate c=em.find(Candidate.class, idUser);
		JobOffer j=em.find(JobOffer.class, idOffer);
		Application application=new Application(c,j);
		em.merge(application);
		
	}
	

}
