package testswing;


import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;

import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



import tn.benamor.businessbuilder.services.JobOfferServiceRemote;
import tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceRemote;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class StatJob extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private Context context;
	    private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobApplicationService!tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceRemote";
	    
	    private static String servicePath1 ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobOfferService!tn.benamor.businessbuilder.services.JobOfferServiceRemote";
	    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					StatJob frame = new StatJob();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StatJob() {
		
		
		
		
		 try {
				context = new InitialContext();
			} catch (NamingException e1) {
			
				e1.printStackTrace();
			}
			 
			 JobApplicationServiceRemote  service = null;
			 try {
				service = (JobApplicationServiceRemote) context.lookup(servicePath);
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
			 
			 
			 
			 try {
					context = new InitialContext();
				} catch (NamingException e1) {
				
					e1.printStackTrace();
				}
				 
				 JobOfferServiceRemote  service1 = null;
				 try {
					service1 = (JobOfferServiceRemote) context.lookup(servicePath1);
				} catch (NamingException e) {
					
					e.printStackTrace();
				}
			 
			 
			 
		DefaultCategoryDataset barCharData=new DefaultCategoryDataset();
		//barCharData.setValue(22, "math","pc");  
		barCharData.addValue(service.findAll().size(), "serie1", "Number of Job Application");
		barCharData.addValue(service1.findAll().size(), "serie2", "Number of Job Offer");
		JFreeChart barChart=ChartFactory.createBarChart3D("statistical", "", "", barCharData, PlotOrientation.VERTICAL, false, true, false);
		/*CategoryPlot barchrt=barChart.getCategoryPlot();
		barchrt.setRangeGridlinePaint(Color.BLACK);
		ChartPanel barpanel=new ChartPanel(barChart);
		scrollPane.removeAll();
	scrollPane.add(barpanel);
	
	scrollPane.validate();*/
	ChartFrame jframe=new ChartFrame("Comparison Between the number of job offer and job application",barChart);
	jframe.pack();
	GroupLayout groupLayout = new GroupLayout(jframe.getChartPanel());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGap(0, 1015, Short.MAX_VALUE)
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGap(0, 425, Short.MAX_VALUE)
	);
	jframe.getChartPanel().setLayout(groupLayout);
	GroupLayout groupLayout_1 = new GroupLayout(jframe.getContentPane());
	groupLayout_1.setHorizontalGroup(
		groupLayout_1.createParallelGroup(Alignment.LEADING)
			.addGap(0, 680, Short.MAX_VALUE)
	);
	groupLayout_1.setVerticalGroup(
		groupLayout_1.createParallelGroup(Alignment.LEADING)
			.addGap(0, 420, Short.MAX_VALUE)
	);
	jframe.getContentPane().setLayout(groupLayout_1);
	jframe.setVisible(true);
	
		
		
	    } 	
		
		
		
		
		
		
	}


