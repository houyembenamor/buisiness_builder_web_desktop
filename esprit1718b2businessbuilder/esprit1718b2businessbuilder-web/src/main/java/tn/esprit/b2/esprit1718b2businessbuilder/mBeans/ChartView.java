package tn.esprit.b2.esprit1718b2businessbuilder.mBeans;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import org.primefaces.model.chart.PieChartModel;

import tn.benamor.businessbuilder.services.JobOfferService;
import tn.benamor.businessbuilder.services.JobOfferServiceLocal;
import tn.benamor.businessbuilder.services.jobapplication.JobApplicationService;
import tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceLocal;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserService;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceLocal;



@ViewScoped
@ManagedBean
public class ChartView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private JobApplicationServiceLocal jobapplication;
	@EJB
	private JobOfferServiceLocal joboffer;
	@EJB
	private UserServiceLocal userservice;
	private PieChartModel pieModel1;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	private void createPieModels() {
		createPieModel1();

	}

	
	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		pieModel1.set("Job Application", jobapplication.findAll().size());
		pieModel1.set("Job Offer", joboffer.findAll().size());
		pieModel1.set("Number of Users", userservice.findAll().size());

		
		
		
		
		pieModel1.setShowDataLabels(true);
		pieModel1.setTitle("Contrat par Classe");
		pieModel1.setLegendPosition("w");
	}

}