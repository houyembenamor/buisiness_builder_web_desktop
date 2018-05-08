package tn.benamor.businessbuilder.services.jobapplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobApplication;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;


/**
 * Session Bean implementation class JobApplicationService
 */
@Stateless
public class JobApplicationService implements JobApplicationServiceRemote, JobApplicationServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public JobApplicationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(JobApplication e) {
		em.persist(e);
		
	}

	@Override
	public List<JobApplication> findAll() {
		return em.createQuery("select e from JobApplication e",JobApplication.class).getResultList();
	}

	@Override
	public void update(JobApplication e) {
		em.merge(e);
		
	}

	@Override
	public void remove(JobApplication e) {
		em.remove(em.merge(e));
		//em.createQuery("delete from JobApplication d where d.idJobApplication = ?1 ").setParameter(1, e.getIdJobApplication()).executeUpdate();
	
	}
	
	public JobApplication findJobApplicationById(int idJobApplication) {
		return em.find(JobApplication.class, idJobApplication);
	}
	@Override
	public boolean updatejob(int idJobApplication ,String statut,String positionInterested,String country,String typeContract ,String sector,Date dateOfBegin) {
		JobApplication std;
		try {
			std=findJobApplicationById(idJobApplication);
		std.setStatut(statut);
			std.setPositionInterested(positionInterested);
			std.setCountry(country);
		  std.setTypeContract(typeContract);
		  std.setSector(sector);
		  std.setDateOfBegin(dateOfBegin);
		
			em.merge(std);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	
	}

	@Override
	public void addJobOfferByCandidate(JobApplication e, int idUser) {
		Candidate candidate = em.find(Candidate.class, idUser);
		e.setCandidate(candidate);
     em.persist(e);
		
	}
	@Override
	public void addJobApplicationToCompanyManager(User user,JobApplication e) {

		List<User> userOld = e.getUsers();
		
			if (userOld != null) {
				userOld.add(user);
				e.linkUsersToThisJobApplication(userOld);
			} else {
				List<User> newOne = new ArrayList<>();
				newOne.add(user);
				e.linkUsersToThisJobApplication(newOne);;
			}

	update(e);
			
		}

}
