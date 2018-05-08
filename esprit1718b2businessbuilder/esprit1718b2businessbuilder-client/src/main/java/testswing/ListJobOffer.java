package testswing;


import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;

public class ListJobOffer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private List<JobOffer> joboffers;
	private List<User>users=new ArrayList<User>();
	private User user =new User();
int xx,xy;
	
	int i;
	String[][] donnes;
	JobOffer job=new JobOffer();
	JobOffer jobofferselected=new JobOffer();
	 private Context context;
	 private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobOfferService!tn.benamor.businessbuilder.services.JobOfferServiceRemote";
	  private static String servicePath1="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/UserService!tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote";
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JTextField textField_5;
	 private JTextField textField_6;
	 private JTextField textField_7;
	 private JTextField textField_8;
	 private JLabel lblNewLabel;
	 private JLabel lblNewLabel_1;
	 private JLabel lblNewLabel_2;
	 private JLabel lblNewLabel_3;
	 private JLabel lblNewLabel_4;
	 private JLabel lblNewLabel_5;
	 private JLabel lblNewLabel_6;
	 private JLabel lblNewLabel_7;
	 private JPanel panel_1;
	 private JLabel lblNewLabel_9;
	 private JTextField textField;
	 private JTextField textField_9;
	 private JButton btnNewButton_2;
	 private JPanel panel_2;
	 private JTable table_1;
	 private JButton btnNewButton_4;
	 private JButton btnNewButton_5;
	 private JPanel panel_3;
	 private JPanel panel_4;
	 private JLabel lblNewLabel_11;
	 private JTextField textField_10;
	 private JLabel lblNewLabel_8;
	 private JLabel lblNewLabel_12;
	 private JLabel label;
	 private JLabel lblNewLabel_10;
	 private JLabel lblNewLabel_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListJobOffer frame = new ListJobOffer();
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
	public ListJobOffer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 780);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(258, 100, 774, 130);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(258, 241, 774, 207);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Update Job Offer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(258, 445, 774, 280);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Assign Candidate to Job Offer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(5, 5, 243, 731);
		
		lblNewLabel_9 = new JLabel("First name");
		lblNewLabel_9.setBounds(125, 31, 89, 14);
		
		textField = new JTextField();
		textField.setBounds(277, 21, 139, 34);
		textField.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(277, 84, 139, 34);
		textField_9.setColumns(10);
		
		btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(241, 57, 83));
		btnNewButton_2.setBounds(509, 24, 139, 28);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
						context = new InitialContext();
					} catch (NamingException e1) {
					
						e1.printStackTrace();
					}
					 
					UserServiceRemote  service1 = null;
					 try {
						service1 = (UserServiceRemote) context.lookup(servicePath1);
					} catch (NamingException e) {
						
						e.printStackTrace();
					}
					 String first = textField.getText();
					 String last = textField_9.getText();
					 user.setFirstName(first);
					 user.setLastName(last);
					 service1.save(user);
				users.add(user);
				initDataBindings();
			}
		});
		
		panel_2 = new JPanel();
		panel_2.setBounds(16, 129, 834, 144);
		panel_2.setBackground(Color.WHITE);
		
		btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(241, 57, 83));
		btnNewButton_5.setBounds(515, 78, 133, 26);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				users.remove(user);
				initDataBindings();
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		
		btnNewButton_4 = new JButton("Assign");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(241, 57, 83));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
					 service.addJobOfferToCandidate(user, jobofferselected);
				initDataBindings();
				JOptionPane.showMessageDialog(null, " Assign added");
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(102)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 609, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(302)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		table_1.setForeground(Color.BLACK);
		table_1.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(table_1);
		panel_2.setLayout(gl_panel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(73, 85, 86, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(73, 136, 86, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(313, 41, 86, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(313, 85, 86, 20);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(312, 136, 86, 20);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(536, 41, 86, 20);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(536, 85, 86, 20);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(536, 136, 86, 20);
		textField_8.setColumns(10);
		
		lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(16, 88, 31, 14);
		
		lblNewLabel_1 = new JLabel("Post Date");
		lblNewLabel_1.setBounds(10, 139, 63, 14);
		
		lblNewLabel_2 = new JLabel("Sector");
		lblNewLabel_2.setBounds(227, 44, 47, 14);
		
		lblNewLabel_3 = new JLabel("Study Level");
		lblNewLabel_3.setBounds(202, 88, 72, 14);
		
		lblNewLabel_4 = new JLabel("Country");
		lblNewLabel_4.setBounds(219, 139, 69, 14);
		
		lblNewLabel_5 = new JLabel("Experience");
		lblNewLabel_5.setBounds(432, 44, 94, 14);
		
		lblNewLabel_6 = new JLabel("Skills");
		lblNewLabel_6.setBounds(432, 88, 77, 14);
		
		lblNewLabel_7 = new JLabel("Job Preferences");
		lblNewLabel_7.setBounds(421, 139, 105, 14);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(241, 57, 83));
		btnNewButton.setBounds(183, 174, 91, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
				
				
				
				  int  idOffer =Integer.parseInt(textField_10.getText());
					
					String title = textField_1.getText();
					String postDate = textField_2.getText();
					String sector = textField_3.getText();
					String studyLevel= textField_4.getText();
					String country = textField_5.getText();
					String experience= textField_6.getText();
					String skills= textField_6.getText();
					String jobPreferences= textField_6.getText();
		
				
					
					if (service.updatejob( idOffer , title, postDate,sector,studyLevel ,country,experience,skills,jobPreferences)){
					
						JOptionPane.showMessageDialog(null, "Updated");
						System.out.println("update");
					}
					else
						JOptionPane.showMessageDialog(null, "Error");
					
					
			}
		});
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(241, 57, 83));
		btnNewButton_1.setBounds(308, 174, 90, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				

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
				
				
				
				
				
				
				int a=table.getSelectedRow();
				int x = Integer.parseInt(donnes[a][0]);
				service.remove(service.findJobOfferById(x));
				System.out.println("deleted");
				try {
					joboffers = new ArrayList<JobOffer>();
					joboffers = (ArrayList<JobOffer>) service.findAll();
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
							new String[] { "Id" ,"Title","Post Date", "Sector", "Study Level", "Country", "Experience","Skills","Job Preferences" }));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		textField_10 = new JTextField();
		textField_10.setBounds(73, 41, 86, 20);
		textField_10.setColumns(10);
		textField_10.setEditable(false);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
		
				
				int a = table.getSelectedRow();
				
				textField_10.setText(donnes[a][0]);
				textField_1.setText(donnes[a][1]);
				
				textField_2.setText(donnes[a][2]);
				textField_3.setText(donnes[a][3]);
				textField_4.setText(donnes[a][4]);
				textField_5.setText(donnes[a][5]);
				textField_6.setText(donnes[a][6]);
				textField_7.setText(donnes[a][7]);
				textField_8.setText(donnes[a][8]);
				
				System.out.println("mouse");
				
			}
			//ApplyJobOffer p= new ApplyJobOffer();
			//p.setVisible(true);
			//setVisible(false);
		});
		scrollPane.setViewportView(table);
		initDataBindings();
		
		
		
		
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
				
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "id" ,"Title","Post Date", "Sector", "Study Level", "Country", "Experience","Skills","JobPreferences"}));
		
			contentPane.setLayout(null);
			contentPane.add(panel_3);
			
			lblNewLabel_11 = new JLabel("New label");
			lblNewLabel_11.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent arg0) {
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					ListJobOffer.this.setLocation(x-xx, y-xy);
				}
			});
			lblNewLabel_11.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					xx=arg0.getX();
					xy=arg0.getY();
				}
			});
			lblNewLabel_11.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_11.setIcon(new ImageIcon(ListJobOffer.class.getResource("/images/bg.jpg")));
			
			label = new JLabel("Business Builder");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Segoe UI", Font.BOLD, 18));
			GroupLayout gl_panel_3 = new GroupLayout(panel_3);
			gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addComponent(lblNewLabel_11, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 243, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addGap(35)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(60, Short.MAX_VALUE))
			);
			gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
						.addGap(66)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(287, Short.MAX_VALUE))
			);
			panel_3.setLayout(gl_panel_3);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			panel_1.add(panel_2);
			panel_1.add(lblNewLabel_9);
			panel_1.add(textField);
			panel_1.add(btnNewButton_2);
			panel_1.add(textField_9);
			panel_1.add(btnNewButton_5);
			
			lblNewLabel_10 = new JLabel("last name");
			lblNewLabel_10.setBounds(125, 73, 78, 14);
			panel_1.add(lblNewLabel_10);
			contentPane.add(scrollPane);
			contentPane.add(panel);
			panel.setLayout(null);
			panel.add(btnNewButton);
			panel.add(btnNewButton_1);
			panel.add(lblNewLabel_1);
			panel.add(lblNewLabel);
			panel.add(textField_2);
			panel.add(lblNewLabel_4);
			panel.add(textField_1);
			panel.add(textField_10);
			panel.add(lblNewLabel_3);
			panel.add(lblNewLabel_2);
			panel.add(textField_5);
			panel.add(lblNewLabel_7);
			panel.add(textField_4);
			panel.add(textField_3);
			panel.add(lblNewLabel_6);
			panel.add(lblNewLabel_5);
			panel.add(textField_7);
			panel.add(textField_6);
			panel.add(textField_8);
			
			panel_4 = new JPanel();
			panel_4.setBackground(new Color(47, 79, 79));
			panel_4.setBounds(248, 5, 786, 87);
			contentPane.add(panel_4);
			
			lblNewLabel_8 = new JLabel("Display the List Of Job Application");
			lblNewLabel_8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new ListJobApplication2().setVisible(true);
				//	new ListJobOffer().setVisible(false);
					
				}
			});
			lblNewLabel_8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblNewLabel_8.setForeground(Color.WHITE);
			
			lblNewLabel_12 = new JLabel("X");
			lblNewLabel_12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			lblNewLabel_12.setForeground(new Color(241, 57, 83));
			lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 18));
			
			lblNewLabel_13 = new JLabel("Home Page");
			lblNewLabel_13.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Login().setVisible(true);
				}
			});
			lblNewLabel_13.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblNewLabel_13.setForeground(Color.WHITE);
			GroupLayout gl_panel_4 = new GroupLayout(panel_4);
			gl_panel_4.setHorizontalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_4.createSequentialGroup()
						.addGap(27)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
								.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
			);
			gl_panel_4.setVerticalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_4.createSequentialGroup()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_8))
							.addComponent(lblNewLabel_12))
						.addGap(18)
						.addComponent(lblNewLabel_13)
						.addContainerGap(18, Short.MAX_VALUE))
			);
			panel_4.setLayout(gl_panel_4);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
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
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty.create("selectedElement.idJobApplication");
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
		//
		JTableBinding<User, List<User>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, users, table_1);
		//
		BeanProperty<User, String> userBeanProperty = BeanProperty.create("firstName");
		jTableBinding_1.addColumnBinding(userBeanProperty).setColumnName("first name");
		//
		BeanProperty<User, String> userBeanProperty_1 = BeanProperty.create("lastName");
		jTableBinding_1.addColumnBinding(userBeanProperty_1).setColumnName("last name");
		//
		jTableBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_9 = BeanProperty.create("selectedElement.firstName");
		BeanProperty<User, String> userBeanProperty_2 = BeanProperty.create("firstName");
		AutoBinding<JTable, String, User, String> autoBinding_9 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_9, user, userBeanProperty_2);
		autoBinding_9.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_10 = BeanProperty.create("selectedElement.lastName");
		BeanProperty<User, String> userBeanProperty_3 = BeanProperty.create("lastName");
		AutoBinding<JTable, String, User, String> autoBinding_10 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table_1, jTableBeanProperty_10, user, userBeanProperty_3);
		autoBinding_10.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<User, String, JTextField, String> autoBinding_11 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, user, userBeanProperty_2, textField, jTextFieldBeanProperty);
		autoBinding_11.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<User, String, JTextField, String> autoBinding_12 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, user, userBeanProperty_3, textField_9, jTextFieldBeanProperty_1);
		autoBinding_12.bind();
	}
}
