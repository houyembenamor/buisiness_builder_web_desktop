package tn.benamor.businessbuilder.services.jobapplication;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobApplication;

@Local
public interface JobApplicationServiceLocal {
	public List <JobApplication >  findAll();
	public void update(JobApplication  e);
	public void remove(JobApplication e); 
}
