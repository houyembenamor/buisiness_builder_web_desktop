package testswing;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.benamor.businessbuilder.services.JobOfferServiceRemote;
import tn.benamor.businessbuilder.services.companymanager.CompanyManagerServiceRemote;
import tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote;

public class Mainjobapplication {

	
	
    
    private static Context context;
    private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobOfferService!tn.benamor.businessbuilder.services.JobOfferServiceRemote";
    
  private static String servicePath2="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/CompanyManagerService!tn.benamor.businessbuilder.services.companymanager.CompanyManagerServiceRemote";
  private static String servicePath3="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/UserService!tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote";
	public static void main(String[] args) throws NamingException {
	
	       
    
			context = new InitialContext();
	
	UserServiceRemote service = (UserServiceRemote) context.lookup(servicePath3);
		
	//CompanyManagerServiceRemote service1 = (CompanyManagerServiceRemote) context.lookup(servicePath2);
//service1.add(new CompanyManager("hayet","hayet","hayet"));
	
//service.addJobOfferByCompanyManager(new JobOffer("amin","amin"),2);
       
       service.addcandidatetojoboffer2(1, 1);
       
	}

}
