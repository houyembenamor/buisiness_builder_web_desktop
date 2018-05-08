package testswing;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobApplication;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.util.ArrayList;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;



import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;


public class ListJobApplication2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private List<JobApplication> jobapplications;
	int i;
	String[][] donnes;
	JobApplication jobselected=new JobApplication();
	 private Context context;
	    private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobApplicationService!tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceRemote";
	    private JPanel panel;
	    private JPanel panel_2;
	    private JLabel lblNewLabel;
	    private JLabel label;
	    private JLabel label_1;
	    private JLabel lblNewLabel_7;
	    private JLabel lblNewLabel_8;
	    private JLabel lblNewLabel_9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListJobApplication2 frame = new ListJobApplication2();
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
	public ListJobApplication2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 479);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(Color.WHITE);
		table.setBorder(new LineBorder(Color.WHITE));
		
				
				
				
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
					jobapplications = new ArrayList<JobApplication>();
					jobapplications= (ArrayList<JobApplication>) service.findAll();
					System.out.println("done");
					donnes = new String[jobapplications.size()][6];
					for (i = 0; i < jobapplications.size(); i++) {
						//donnes[i][0] = String.valueOf(jobapplications.get(i).getIdJobApplication());
						donnes[i][0] = jobapplications.get(i).getStatut();
						donnes[i][1] = jobapplications.get(i).getPositionInterested();
						donnes[i][2] = jobapplications.get(i).getCountry();
						donnes[i][3] = jobapplications.get(i).getTypeContract();
						donnes[i][4] = jobapplications.get(i).getSector();
						donnes[i][5] = jobapplications.get(i).getDateOfBegin();
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] {"Statut","Interested Position", "Country", "Contract Type", "Sector", "Date Begin"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		
		
	
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(ListJobApplication2.class.getResource("/images/bg.jpg")));
		
		label = new JLabel("");
		
		label_1 = new JLabel("Business Builder");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 208, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(53)
					.addComponent(label)
					.addContainerGap(155, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(label)
					.addContainerGap(175, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		lblNewLabel_7 = new JLabel("X");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setForeground(Color.WHITE);
		
		lblNewLabel_8 = new JLabel("Display Job Offers");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new List2JobOffer().setVisible(true);
			}
		});
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_8.setForeground(Color.WHITE);
		
		lblNewLabel_9 = new JLabel("Home Page");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
			}
		});
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Assign Job Application");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AssignJobApplication().setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_8))
					.addGap(14)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_9)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<JobApplication, java.util.List<JobApplication>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, jobapplications, table);
		//
		BeanProperty<JobApplication, Integer> jobApplicationBeanProperty = BeanProperty.create("idJobApplication");
		jTableBinding.addColumnBinding(jobApplicationBeanProperty).setColumnName("id");
		//
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_1 = BeanProperty.create("statut");
		jTableBinding.addColumnBinding(jobApplicationBeanProperty_1).setColumnName("Statut");
		//
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_2 = BeanProperty.create("positionInterested");
		jTableBinding.addColumnBinding(jobApplicationBeanProperty_2).setColumnName("Interested Positions");
		//
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_3 = BeanProperty.create("country");
		jTableBinding.addColumnBinding(jobApplicationBeanProperty_3).setColumnName("Country");
		//
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_4 = BeanProperty.create("typeContract");
		jTableBinding.addColumnBinding(jobApplicationBeanProperty_4).setColumnName("Type Of Contract");
		//
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_5 = BeanProperty.create("sector");
		jTableBinding.addColumnBinding(jobApplicationBeanProperty_5).setColumnName("Sector");
		//
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_6 = BeanProperty.create("dateOfBegin");
		jTableBinding.addColumnBinding(jobApplicationBeanProperty_6).setColumnName("Date Begin");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty.create("selectedElement.idJobApplication");
		BeanProperty<JobApplication, Integer> jobApplicationBeanProperty_7 = BeanProperty.create("idJobApplication");
		AutoBinding<JTable, Integer, JobApplication, Integer> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, jobselected, jobApplicationBeanProperty_7);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.statut");
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_8 = BeanProperty.create("statut");
		AutoBinding<JTable, String, JobApplication, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, jobselected, jobApplicationBeanProperty_8);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.positionInterested");
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_9 = BeanProperty.create("positionInterested");
		AutoBinding<JTable, String, JobApplication, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, jobselected, jobApplicationBeanProperty_9);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_3 = BeanProperty.create("selectedElement.country");
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_10 = BeanProperty.create("country");
		AutoBinding<JTable, String, JobApplication, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, jobselected, jobApplicationBeanProperty_10);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty.create("selectedElement.typeContract");
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_11 = BeanProperty.create("typeContract");
		AutoBinding<JTable, String, JobApplication, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_4, jobselected, jobApplicationBeanProperty_11);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_5 = BeanProperty.create("selectedElement.sector");
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_12 = BeanProperty.create("sector");
		AutoBinding<JTable, String, JobApplication, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_5, jobselected, jobApplicationBeanProperty_12);
		autoBinding_5.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_6 = BeanProperty.create("selectedElement.dateOfBegin");
		BeanProperty<JobApplication, String> jobApplicationBeanProperty_13 = BeanProperty.create("dateOfBegin");
		AutoBinding<JTable, String, JobApplication, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_6, jobselected, jobApplicationBeanProperty_13);
		autoBinding_6.bind();
	}
}
