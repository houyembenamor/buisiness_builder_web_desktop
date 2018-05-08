package tn.benamor.businessbuilder.services.companymanager;

import javax.ejb.Local;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;

@Local
public interface CompanyManagerServiceLocal {
	public CompanyManager findCompanyManagerByName(String companyName);
}
