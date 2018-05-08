package tn.benamor.businessbuilder.services;


import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;

@Remote
public interface JobOfferServiceRemote {
public void add(JobOffer e);
public List <JobOffer>  findAll();
public List<JobOffer> findJobOfferByCompanyManager(CompanyManager companyName);
public void update(JobOffer e);
public void remove(JobOffer e);
public boolean updatejob(int idOffer ,String title,Date postDate,String sector,String studyLevel ,String country,String experience,String skills,String jobPreferences);
public JobOffer findJobOfferById(int idOffer);
public JobOffer findJobOfferByIdUser(int idUser);
public void addJobOfferByCompanyManager(JobOffer e,int idUser);
public void addJobOfferToCandidate(User user,JobOffer e) ;

}
