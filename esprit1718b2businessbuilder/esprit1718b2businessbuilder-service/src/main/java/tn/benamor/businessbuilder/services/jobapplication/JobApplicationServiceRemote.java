package tn.benamor.businessbuilder.services.jobapplication;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobApplication;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;



@Remote
public interface JobApplicationServiceRemote {
	public void add(JobApplication e);
	public List <JobApplication >  findAll();
	public void update(JobApplication  e);
	public void remove(JobApplication e); 
	public JobApplication findJobApplicationById(int idJobApplication);
	public boolean updatejob(int idJobApplication ,String statut,String positionInterested,String country,String typeContract ,String sector,Date dateOfBegin);
	public void addJobOfferByCandidate(JobApplication e,int idUser);
	public void addJobApplicationToCompanyManager(User user,JobApplication e);
}
