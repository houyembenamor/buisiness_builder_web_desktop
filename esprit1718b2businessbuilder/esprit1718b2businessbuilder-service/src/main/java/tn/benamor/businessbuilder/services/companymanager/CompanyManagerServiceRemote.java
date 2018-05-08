package tn.benamor.businessbuilder.services.companymanager;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;

@Remote
public interface CompanyManagerServiceRemote {
	public void add(CompanyManager e);
	public List <CompanyManager>  findAll();
	public void update(CompanyManager e);
	public void remove(CompanyManager e);
	public CompanyManager findCompanyManagerByName(String companyName );
	public CompanyManager findCompanyManagerByAddress(String companyAddress );
}
