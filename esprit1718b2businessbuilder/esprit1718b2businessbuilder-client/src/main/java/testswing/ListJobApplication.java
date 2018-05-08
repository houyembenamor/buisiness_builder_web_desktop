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


public class ListJobApplication extends JFrame {

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
	    private JTextField textField;
	    private JTextField textField_1;
	    private JTextField textField_2;
	    private JTextField textField_3;
	    private JTextField textField_4;
	    private JTextField textField_5;
	    private JTextField textField_6;
	    private JLabel lblNewLabel_1;
	    private JLabel lblNewLabel_2;
	    private JLabel lblNewLabel_3;
	    private JLabel lblNewLabel_4;
	    private JLabel lblNewLabel_5;
	    private JLabel lblNewLabel_6;
	    private JPanel panel;
	    private JPanel panel_1;
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
					ListJobApplication frame = new ListJobApplication();
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
	public ListJobApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 624);
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				
				int a = table.getSelectedRow();
				
				textField.setText(donnes[a][0]);
				textField_1.setText(donnes[a][1]);
				
				textField_2.setText(donnes[a][2]);
				textField_3.setText(donnes[a][3]);
				textField_4.setText(donnes[a][4]);
				textField_5.setText(donnes[a][5]);
				textField_6.setText(donnes[a][6]);
				
				System.out.println("mouse");
				
				
				
				
				
			}
		});
		
				
				
				
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
					donnes = new String[jobapplications.size()][7];
					for (i = 0; i < jobapplications.size(); i++) {
						donnes[i][0] = String.valueOf(jobapplications.get(i).getIdJobApplication());
						donnes[i][1] = jobapplications.get(i).getStatut();
						donnes[i][2] = jobapplications.get(i).getPositionInterested();
						donnes[i][3] = jobapplications.get(i).getCountry();
						donnes[i][4] = jobapplications.get(i).getTypeContract();
						donnes[i][5] = jobapplications.get(i).getSector();
						donnes[i][6] = jobapplications.get(i).getDateOfBegin();
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "idJobApplication" ,"Statut","Interested Position", "Country", "Contract Type", "Sector", "Date Begin"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		
		
	
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(ListJobApplication.class.getResource("/images/bg.jpg")));
		
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
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addGap(95)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(131))
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
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
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
					.addGap(39)
					.addComponent(lblNewLabel_9)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(399, 59, 199, 20);
		textField_5.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 102, 204, 20);
		textField_2.setColumns(10);
		
		
		
		textField = new JTextField();
		textField.setBounds(87, 21, 204, 20);
		textField.setColumns(10);
		textField.setEditable(false);
		textField_3 = new JTextField();
		textField_3.setBounds(399, 21, 199, 20);
		textField_3.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Sector");
		lblNewLabel_5.setBounds(328, 62, 31, 14);
		
		textField_6 = new JTextField();
		textField_6.setBounds(399, 102, 204, 20);
		textField_6.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 59, 204, 20);
		textField_1.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Contract Type");
		lblNewLabel_4.setBounds(316, 24, 69, 14);
		
		lblNewLabel_6 = new JLabel("Date Begin");
		lblNewLabel_6.setBounds(316, 105, 52, 14);
		
		lblNewLabel_1 = new JLabel("Statut");
		lblNewLabel_1.setBounds(8, 62, 30, 14);
		
		lblNewLabel_3 = new JLabel("Country");
		lblNewLabel_3.setBounds(8, 136, 39, 14);
		
		lblNewLabel_2 = new JLabel("Position");
		lblNewLabel_2.setBounds(10, 105, 37, 14);
		
	
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(new Color(241, 57, 83));
		btnNewButton_1.setBounds(135, 188, 134, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
				
				
				
				
				
				
				int a=table.getSelectedRow();
				int x = Integer.parseInt(donnes[a][0]);
				service.remove(service.findJobApplicationById(x));
				System.out.println("deleted");
				try {
					jobapplications = new ArrayList<JobApplication>();
					jobapplications= (ArrayList<JobApplication>) service.findAll();
					System.out.println("done");
					donnes = new String[jobapplications.size()][7];
					for (i = 0; i < jobapplications.size(); i++) {
						donnes[i][0] = String.valueOf(jobapplications.get(i).getIdJobApplication());
						donnes[i][1] = jobapplications.get(i).getStatut();
						donnes[i][2] = jobapplications.get(i).getPositionInterested();
						donnes[i][3] = jobapplications.get(i).getCountry();
						donnes[i][4] = jobapplications.get(i).getTypeContract();
						donnes[i][5] = jobapplications.get(i).getSector();
						donnes[i][6] = jobapplications.get(i).getDateOfBegin();
						
						
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "idJobApplication" ,"Statut","Interested Position", "Country", "Contract Type", "Sector", "Date Begin"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(new Color(241, 57, 83));
		btnNewButton.setBounds(398, 188, 134, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
				
			
					 
					// int x = table.getSelectedRow();
						
						  int  idJobApplication =Integer.parseInt(textField.getText());
					
						String statut = textField_1.getText();
						String positionInterested = textField_2.getText();
						String  country = textField_3.getText();
						String typeContract= textField_4.getText();
						String sector = textField_5.getText();
						String dateOfBegin= textField_6.getText();
					
						
			
					
						
						if (service.updatejob(idJobApplication ,statut,positionInterested,country,typeContract ,sector,dateOfBegin)){
						
							JOptionPane.showMessageDialog(null, "Updated");
							System.out.println("update");
						}
						else
							JOptionPane.showMessageDialog(null, "Error");
						
						
					 
					 
					 
				//service.update(jobselected);
				//jobapplications=service.findAll();
				//initDataBindings();
				
			}
		});
		
		textField_4 = new JTextField();
		textField_4.setBounds(87, 133, 204, 20);
		textField_4.setColumns(10);
		panel_1.setLayout(null);
		panel_1.add(textField_5);
		panel_1.add(textField_2);
		panel_1.add(textField);
		panel_1.add(textField_3);
		panel_1.add(lblNewLabel_5);
		panel_1.add(textField_6);
		panel_1.add(textField_1);
		panel_1.add(lblNewLabel_4);
		panel_1.add(lblNewLabel_6);
		panel_1.add(lblNewLabel_1);
		panel_1.add(lblNewLabel_3);
		panel_1.add(lblNewLabel_2);
		panel_1.add(btnNewButton_1);
		panel_1.add(btnNewButton);
		panel_1.add(textField_4);
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
