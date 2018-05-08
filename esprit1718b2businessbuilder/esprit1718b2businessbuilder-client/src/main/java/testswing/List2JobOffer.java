package testswing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.benamor.businessbuilder.services.JobOfferServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Panel;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionAdapter;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;

public class List2JobOffer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private List<JobOffer> joboffers;
	int i;
	String[][] donnes;
	JobOffer jobofferselected=new JobOffer();
	 private Context context;
	 int xx,xy;
	 private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobOfferService!tn.benamor.businessbuilder.services.JobOfferServiceRemote";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List2JobOffer frame = new List2JobOffer();
					frame.setUndecorated(true);
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
	public List2JobOffer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		

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
		
		
		
		
		
		try {
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
			//	donnes[i][9] = joboffers.get(i).getCompanyManager().getCompanyName();
			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(null);
			
			table = new JTable();
			table.setBorder(new LineBorder(Color.WHITE));
			table.setForeground(Color.WHITE);
		/*	table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int a = table.getSelectedRow();
				//	JobOffer j= new JobOffer();
				
					int x = Integer.parseInt(donnes[a][0]);
					 new ApplyJobOffer(x).setVisible(true);
					
					setVisible(false);
					
				}
			});*/
			scrollPane.setViewportView(table);
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "id" ,"Title","Post Date", "Sector", "Study Level", "Country", "Experience","Skills","JobPreferences"}));
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(47, 79, 79));
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addGap(45))
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
			);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Add Your Job Application");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					new addjobapplication().setVisible(true);
				}
			});
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(39, 22, 199, 29);
			panel_1.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Home Page");
			lblNewLabel_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Login().setVisible(true);
				}
			});
			lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(39, 63, 150, 37);
			panel_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("X");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_4.setForeground(new Color(255, 20, 147));
			lblNewLabel_4.setBounds(583, 11, 23, 29);
			panel_1.add(lblNewLabel_4);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					int x=e.getXOnScreen();
					int y=e.getYOnScreen();
					List2JobOffer.this.setLocation(x-xx, y-xy);
				}
			});
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					xx=e.getX();
					xy=e.getY();
				}
			});
			lblNewLabel.setIcon(new ImageIcon(List2JobOffer.class.getResource("/images/bg.jpg")));
			lblNewLabel.setBounds(0, -19, 287, 301);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Business Builder");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBackground(Color.BLACK);
			lblNewLabel_1.setBounds(73, 339, 161, 43);
			panel.add(lblNewLabel_1);
			contentPane.setLayout(gl_contentPane);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		initDataBindings();
		
		
		
		
		
	}
	protected void initDataBindings() {
		JTableBinding<JobOffer, List<JobOffer>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, joboffers, table);
		//
		BeanProperty<JobOffer, Integer> jobOfferBeanProperty = BeanProperty.create("idOffer");
		jTableBinding.addColumnBinding(jobOfferBeanProperty).setColumnName("Id");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_2 = BeanProperty.create("title");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_2).setColumnName("Title");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_3 = BeanProperty.create("postDate");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_3).setColumnName("Post Date");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_4 = BeanProperty.create("sector");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_4).setColumnName("Sector");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_5 = BeanProperty.create("studyLevel");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_5).setColumnName("Study Level");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_6 = BeanProperty.create("country");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_6).setColumnName("Country");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_7 = BeanProperty.create("experience");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_7).setColumnName("Experience");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_8 = BeanProperty.create("skills");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_8).setColumnName("Skills");
		//
		BeanProperty<JobOffer, String> jobOfferBeanProperty_18 = BeanProperty.create("jobPreferences");
		jTableBinding.addColumnBinding(jobOfferBeanProperty_18).setColumnName("Job Preferences");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty.create("selectedElement.idOffer");
		BeanProperty<JobOffer, Integer> jobOfferBeanProperty_9 = BeanProperty.create("idOffer");
		AutoBinding<JTable, Integer, JobOffer, Integer> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, jobofferselected, jobOfferBeanProperty_9);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.title");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_10 = BeanProperty.create("title");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, jobofferselected, jobOfferBeanProperty_10);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.postDate");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_11 = BeanProperty.create("postDate");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, jobofferselected, jobOfferBeanProperty_11);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_3 = BeanProperty.create("selectedElement.sector");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_12 = BeanProperty.create("sector");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, jobofferselected, jobOfferBeanProperty_12);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty.create("selectedElement.studyLevel");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_13 = BeanProperty.create("studyLevel");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_4, jobofferselected, jobOfferBeanProperty_13);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_5 = BeanProperty.create("selectedElement.country");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_14 = BeanProperty.create("country");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_5, jobofferselected, jobOfferBeanProperty_14);
		autoBinding_5.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_6 = BeanProperty.create("selectedElement.experience");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_15 = BeanProperty.create("experience");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_6, jobofferselected, jobOfferBeanProperty_15);
		autoBinding_6.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_7 = BeanProperty.create("selectedElement.skills");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_16 = BeanProperty.create("skills");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_7, jobofferselected, jobOfferBeanProperty_16);
		autoBinding_7.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_8 = BeanProperty.create("selectedElement.jobPreferences");
		BeanProperty<JobOffer, String> jobOfferBeanProperty_17 = BeanProperty.create("jobPreferences");
		AutoBinding<JTable, String, JobOffer, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_8, jobofferselected, jobOfferBeanProperty_17);
		autoBinding_8.bind();
	}
}
