package testswing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.benamor.buisinessbuilder.services.candidate.CandidateServiceRemote;
import tn.benamor.businessbuilder.services.JobOfferServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ObjectProperty;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Postuler extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private List<JobOffer> joboffers;
	JobOffer selected=new JobOffer();
	private List<User> candidates;
	User selectedcan=new User();
	int i;
	String[][] donnes;
	int j;
	String[][] donnes1;
	 private Context context;
	 private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobOfferService!tn.benamor.businessbuilder.services.JobOfferServiceRemote";
	private static String servicePath1="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/CandidateService!tn.benamor.buisinessbuilder.services.candidate.CandidateServiceRemote";
	 private static String servicePath2="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/UserService!tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Postuler frame = new Postuler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Postuler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				 try {
						context = new InitialContext();
					} catch (NamingException e1) {
					
						e1.printStackTrace();
					}
					 
				 UserServiceRemote  service2 = null;
					 try {
						service2= (UserServiceRemote) context.lookup(servicePath2);
					} catch (NamingException e) {
						
						e.printStackTrace();
					}
			int	a=selected.getIdOffer();
			int b=selectedcan.getIdUser();
				service2.addcandidatetojoboffer2(b, a);
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(248)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);
		table_1.setModel(new javax.swing.table.DefaultTableModel(donnes1,
				new String[] { "id" ,"first name","last name", "email", "nationality", "resume"}));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		
		

		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		 try {
				context = new InitialContext();
			} catch (NamingException e1) {
			
				e1.printStackTrace();
			}
			 
			 JobOfferServiceRemote  service = null;
			 try {
				service = (JobOfferServiceRemote) context.lookup(servicePath);
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
		
		joboffers=service.findAll();
		initDataBindings();
		
		
		/*
			joboffers = new ArrayList<JobOffer>();
			joboffers= (ArrayList<JobOffer>) service.findAll();
			System.out.println("done");
			donnes = new String[joboffers.size()][9];
			for (i = 0; i < joboffers.size(); i++) {
				donnes[i][0] = String.valueOf(joboffers.get(i).getIdOffer());
				donnes[i][1] = joboffers.get(i).getTitle();
				donnes[i][2] = joboffers.get(i).getPostDate();
				donnes[i][3] = joboffers.get(i).getSector();
				donnes[i][4] = joboffers.get(i).getStudyLevel();
				donnes[i][5] = joboffers.get(i).getCountry();
				donnes[i][6] = joboffers.get(i).getExperience();
				donnes[i][7] = joboffers.get(i).getSkills();
				donnes[i][8] = joboffers.get(i).getJobPreferences();
				
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
			new String[] { "Id" ,"title","post date", "sector", "study level", "country", "experience","skills","job preferences"}));
		
	*/
			
			
			
			
			
			 try {
					context = new InitialContext();
				} catch (NamingException e1) {
				
					e1.printStackTrace();
				}
				 
			 UserServiceRemote  service1 = null;
				 try {
					service1 = (UserServiceRemote) context.lookup(servicePath2);
				} catch (NamingException e) {
					
					e.printStackTrace();
				}
			
			
				 candidates =service1.findAll();
			
				
			
			/*	candidates = new ArrayList<User>();
				 candidates= (ArrayList<User>) service1.findAll();
				System.out.println("done");
				donnes1 = new String[candidates.size()][6];
				for (j = 0; j < candidates.size(); j++) {
					donnes1[j][0] = String.valueOf(candidates.get(j).getIdUser());
					donnes1[j][1] = candidates.get(j).getFirstName();
					donnes1[j][2] = candidates.get(j).getLastName();
					donnes1[j][3] = candidates.get(j).getEmail();
					donnes1[j][4] = candidates.get(j).getNationality();
					//donnes1[j][5] = candidates.get(j).getResume();
					//donnes1[j][6] = candidates.get(j).getDomain();
					donnes1[j][5] = candidates.get(j).getUserName();
					
					
					
				}*/
				initDataBindings();
			
			
			
			
			
	}
	protected void initDataBindings() {
		JTableBinding<JobOffer, List<JobOffer>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, joboffers, table);
		//
		BeanProperty<JobOffer, Integer> jobOfferBeanProperty = BeanProperty.create("idOffer");
		jTableBinding.addColumnBinding(jobOfferBeanProperty).setColumnName("id");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_1 = BeanProperty.create("title");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_1).setColumnName("title");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_2 = BeanProperty.create("studyLevel");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_2).setColumnName("study");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_3 = BeanProperty.create("postDate");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_3).setColumnName("post date");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_4 = BeanProperty.create("country");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_4).setColumnName("country");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_5 = BeanProperty.create("experience");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_5).setColumnName("experience");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_6 = BeanProperty.create("jobPreferences");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_6).setColumnName("job preferences");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_7 = BeanProperty.create("skills");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_7).setColumnName("skills");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty.create("selectedElement.title");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_8 = BeanProperty.create("title");
		AutoBinding<JTable, String, JobOffer, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, selected, jobOfferBeanProperty_8);
		autoBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_1 = BeanProperty.create("selectedElement.idOffer");
		BeanProperty<JobOffer, Integer> jobOfferBeanProperty_9 = BeanProperty.create("idOffer");
		AutoBinding<JTable, Integer, JobOffer, Integer> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, selected, jobOfferBeanProperty_9);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.country");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_10 = BeanProperty.create("country");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, selected, jobOfferBeanProperty_10);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_3 = BeanProperty.create("selectedElement.experience");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_11 = BeanProperty.create("experience");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, selected, jobOfferBeanProperty_11);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty.create("selectedElement.jobPreferences");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_12 = BeanProperty.create("jobPreferences");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_4, selected, jobOfferBeanProperty_12);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_5 = BeanProperty.create("selectedElement.postDate");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_13 = BeanProperty.create("postDate");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_5, selected, jobOfferBeanProperty_13);
		autoBinding_5.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_6 = BeanProperty.create("selectedElement.sector");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_14 = BeanProperty.create("sector");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_6, selected, jobOfferBeanProperty_14);
		autoBinding_6.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_7 = BeanProperty.create("selectedElement.skills");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_15 = BeanProperty.create("skills");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_7, selected, jobOfferBeanProperty_15);
		autoBinding_7.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_8 = BeanProperty.create("selectedElement.studyLevel");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_16 = BeanProperty.create("studyLevel");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_8, selected, jobOfferBeanProperty_16);
		autoBinding_8.bind();
		//
		JTableBinding<User, List<User>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, candidates, table_1);
		//
		BeanProperty<User, Integer> userBeanProperty = BeanProperty.create("idUser");
		jTableBinding_1.addColumnBinding(userBeanProperty).setColumnName("New Column");
		//
		BeanProperty<User, String> userBeanProperty_1 = BeanProperty.create("firstName");
		jTableBinding_1.addColumnBinding(userBeanProperty_1).setColumnName("New Column");
		//
		BeanProperty<User, String> userBeanProperty_2 = BeanProperty.create("lastName");
		jTableBinding_1.addColumnBinding(userBeanProperty_2).setColumnName("New Column");
		//
		BeanProperty<User, String> userBeanProperty_3 = BeanProperty.create("email");
		jTableBinding_1.addColumnBinding(userBeanProperty_3).setColumnName("New Column");
		//
		BeanProperty<User, String> userBeanProperty_4 = BeanProperty.create("userName");
		jTableBinding_1.addColumnBinding(userBeanProperty_4).setColumnName("New Column");
		//
		jTableBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_9 = BeanProperty.create("selectedElement.email");
		BeanProperty<User, String> userBeanProperty_5 = BeanProperty.create("email");
		AutoBinding<JTable, String, User, String> autoBinding_9 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_9, selectedcan, userBeanProperty_5);
		autoBinding_9.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_10 = BeanProperty.create("selectedElement.firstName");
		BeanProperty<User, String> userBeanProperty_6 = BeanProperty.create("firstName");
		AutoBinding<JTable, String, User, String> autoBinding_10 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_10, selectedcan, userBeanProperty_6);
		autoBinding_10.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_11 = BeanProperty.create("selectedElement.idUser");
		BeanProperty<User, Integer> userBeanProperty_7 = BeanProperty.create("idUser");
		AutoBinding<JTable, Integer, User, Integer> autoBinding_11 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_11, selectedcan, userBeanProperty_7);
		autoBinding_11.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_12 = BeanProperty.create("selectedElement.lastName");
		BeanProperty<User, String> userBeanProperty_8 = BeanProperty.create("lastName");
		AutoBinding<JTable, String, User, String> autoBinding_12 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_12, selectedcan, userBeanProperty_8);
		autoBinding_12.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_13 = BeanProperty.create("selectedElement.userName");
		BeanProperty<User, String> userBeanProperty_9 = BeanProperty.create("userName");
		AutoBinding<JTable, String, User, String> autoBinding_13 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_13, selectedcan, userBeanProperty_9);
		autoBinding_13.bind();
	}
}
