package tn.benamor.businessbuilder.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;

@Local
public interface JobOfferServiceLocal {
	public JobOffer findJobOfferById(int idOffer);
	public void add(JobOffer e);
	public List <JobOffer>  findAll();
	public void update(JobOffer e);
	public void remove(JobOffer e);
}
