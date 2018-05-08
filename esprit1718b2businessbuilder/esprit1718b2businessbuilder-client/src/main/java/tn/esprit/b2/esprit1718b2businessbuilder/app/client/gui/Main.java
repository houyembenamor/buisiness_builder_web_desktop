package tn.esprit.b2.esprit1718b2businessbuilder.app.client.gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.benamor.businessbuilder.services.JobOfferServiceRemote;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;

public class Main {
	 private static Context context;
	    private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobOfferService!tn.benamor.businessbuilder.services.JobOfferServiceRemote";
	    
	    @PersistenceContext
		private static EntityManager em;

	public static void main(String[] args) throws NamingException {
		 
	   
		
		
		       
	    
				context = new InitialContext();
		
		JobOfferServiceRemote service = (JobOfferServiceRemote) context.lookup(servicePath);
			
			

		//CompanyManagerServiceRemote 	service1= (CompanyManagerServiceRemote  ) context.lookup(servicePath2);
			
	  	CompanyManager z=new CompanyManager();
	  	z.setCompanyName("ff");
	  	z.setEmail("hh");
	  	z.setFirstName("jj");
	  	z.setLastName("hh");
	  
	  //	service1.add(z);
	  	JobOffer st = new JobOffer();
	       st.setTitle("houyem3");
	       st.setCountry("tunisie4");
	       st.setCompanyManager(z);
	       service.add(st);

	        
	    
	     
	}

}
