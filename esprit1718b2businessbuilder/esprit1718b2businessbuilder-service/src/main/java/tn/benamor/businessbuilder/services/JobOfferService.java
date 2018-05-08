package tn.benamor.businessbuilder.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.benamor.buisinessbuilder.services.candidate.CandidateServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceLocal;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote;

/**
 * Session Bean implementation class Event
 */
@Stateless
@LocalBean
public class JobOfferService implements JobOfferServiceRemote, JobOfferServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public JobOfferService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void add(JobOffer e) {
		em.persist(e);
		
	}
	@Override
	public List<JobOffer> findAll() {
		
		return em.createQuery("select e from JobOffer e",JobOffer.class).getResultList();
	}
	@Override
	public void update(JobOffer e) {
		em.merge(e);
		
	}
	@Override
	public void remove(JobOffer e) {
		
		em.remove(em.merge(e));
	}
	
	public JobOffer findJobOfferById(int idOffer) {
		return em.find(JobOffer.class, idOffer);
	}
	@Override
	public boolean updatejob(int idOffer ,String title,Date postDate,String sector,String studyLevel ,String country,String experience,String skills,String jobPreferences) {
		JobOffer std;
		try {
			std=findJobOfferById(idOffer);
		std.setTitle(title);
			std.setPostDate(postDate);
			std.setCountry(country);
		  std.setSector(sector);
		  std.setSkills(skills);
		  std.setJobPreferences(jobPreferences);
		  std.setStudyLevel(studyLevel);
		  std.setExperience(experience);
		  
		  
			em.merge(std);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	
	}
	@Override
	public List<JobOffer> findJobOfferByCompanyManager(CompanyManager companyName) {
		return em.createQuery("select p from JobOffer p where p.companyName.idUser=:c",JobOffer.class).setParameter("c", companyName)
				.getResultList();
		
	}
	
	

	@Override
	public void addJobOfferByCompanyManager(JobOffer e, int idUser) {
		CompanyManager companyManager = em.find(CompanyManager.class, idUser);
		e.setCompanyManager(companyManager);
     em.persist(e);
		
	}
	@Override
	public JobOffer findJobOfferByIdUser(int idUser) {
		return em.find(JobOffer.class, idUser);
	}
	@Override
	public void addJobOfferToCandidate(User user,JobOffer e) {

		List<User> jobOld = e.getUsers();
		
			if (jobOld != null) {
				jobOld .add(user);
				e.linkUsersToThisJobOffer(jobOld);
			} else {
				List<User> newOne = new ArrayList<>();
				newOne.add(user);
				e.linkUsersToThisJobOffer(newOne);
			}

	update(e);
			
		}
	
	
	
	
	
	
	
}
