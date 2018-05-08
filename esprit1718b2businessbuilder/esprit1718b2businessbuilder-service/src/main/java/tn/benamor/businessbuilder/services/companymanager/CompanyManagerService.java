package tn.benamor.businessbuilder.services.companymanager;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;

/**
 * Session Bean implementation class CompanyManagerService
 */
@Stateless
public class CompanyManagerService implements CompanyManagerServiceRemote, CompanyManagerServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public CompanyManagerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(CompanyManager e) {
		em.persist(e);
		
		
	}

	@Override
	public List<CompanyManager> findAll() {
		return em.createQuery("select e from CompanyManager e",CompanyManager.class).getResultList();
	}

	@Override
	public void update(CompanyManager e) {
		em.merge(e);
		
	}

	@Override
	public void remove(CompanyManager e) {
		em.remove(em.merge(e));
		
	}

	@Override
	public CompanyManager findCompanyManagerByName(String companyName) {
		return em.find(CompanyManager.class, companyName);
	}

	@Override
	public CompanyManager findCompanyManagerByAddress(String companyAddress) {
		return em.find(CompanyManager.class, companyAddress);
	}

}
