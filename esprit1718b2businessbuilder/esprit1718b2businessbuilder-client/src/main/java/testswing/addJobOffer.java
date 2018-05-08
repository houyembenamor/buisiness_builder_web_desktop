package testswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import tn.benamor.businessbuilder.services.JobOfferServiceRemote;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;




public class addJobOffer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	   private Context context;
	    private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobOfferService!tn.benamor.businessbuilder.services.JobOfferServiceRemote";
	int xx,xy;
	
	    
	  private static String servicePath1="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/UserService!tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote";
	    List <JobOffer> joboffers;
	    JobOffer jobofferselected=new JobOffer();
	    public static  JobOffer cm;


	  
	  private List<CompanyManager> companymanagers;
		int i;
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addJobOffer frame = new addJobOffer();
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
	public addJobOffer() {
		setTitle("Job Offer Management");

		
		 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 617);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(5, 5, 285, 578);
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					int x=e.getXOnScreen();
					int y=e.getYOnScreen();
					addJobOffer.this.setLocation(x-xx, y-xy);
				}
			});
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					xx=e.getX();
					xy=e.getY();
				}
			});
			lblNewLabel_1.setIcon(new ImageIcon(addJobOffer.class.getResource("/images/bg.jpg")));
			lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1.setBounds(0, 0, 285, 275);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Business Builder");
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(80, 376, 160, 39);
			panel_1.add(lblNewLabel_2);
			
			Label label_1 = new Label("Post Date");
			label_1.setBounds(643, 154, 60, 22);
			
			JButton button = new JButton("Add Job Offer");
			button.setBackground(new Color(241, 57, 83));
			button.setBounds(474, 543, 240, 34);
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(643, 184, 214, 33);
			dateChooser.getCalendarButton().setForeground(new Color(204, 0, 153));
			dateChooser.getCalendarButton().setBackground(new Color(204, 102, 153));
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Full-Time");
			rdbtnNewRadioButton.setBounds(450, 456, 89, 23);
			JRadioButton radioButton = new JRadioButton("Temporary");
			radioButton.setBounds(551, 456, 99, 23);
			JRadioButton radioButton_1 = new JRadioButton("Part-Time");
			radioButton_1.setBounds(689, 456, 89, 23);
			
				JRadioButton radioButton_3 = new JRadioButton("from a distance");
				radioButton_3.setBounds(474, 499, 127, 23);
				JRadioButton radioButton_2 = new JRadioButton("Trainee");
				radioButton_2.setBounds(796, 456, 77, 23);
			
			button.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0) {
					

			       
			             try {
							context = new InitialContext();
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			   
					JobOfferServiceRemote  service = null;
			  
			             try {
							service = (JobOfferServiceRemote) context.lookup(servicePath);
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			     

			             try {
							context = new InitialContext();
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			   
					UserServiceRemote  service1 = null;
			  
			             try {
							service1 = (UserServiceRemote) context.lookup(servicePath1);
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			           
			       
			             
			             
			             
			   
			             
			             
			      //    Login x=new Login();
					  //   int y=x.getId();
			         //   String y=x.getCompanyName();
					  //    int	y = Integer.parseInt(textField_6.getText());
					 
			//	textField_6.setText(Integer.toString(y));
			            //textField_6.setText(y);
					String title = textField.getText();
					String sector = textField_1.getText();
				
					String studyLevel = textField_2.getText();

					String country = textField_3.getText();
					String skills = textField_4.getText();
			
					String experience = textField_5.getText();
				//	int	s = Integer.parseInt(textField_6.getText());
			
	
	
	
	//Login l=new Login();
	
	User pr=(User)Login.user;
	User pr1=service1.findUserById(pr.getIdUser());
	
	
	
				
				String postDate=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
					
					JobOffer st = new JobOffer();
					
					st.setTitle(title);
				
					st.setPostDate(postDate);
					st.setSector(sector);
					st.setCountry(country);
					st.setStudyLevel(studyLevel);
					st.setSkills(skills);
					st.setExperience(experience);
//st.setCompanyManager(z);
				// st.getCompanyManager(z.getIdUser());
				//z.getFirstName();
					if(rdbtnNewRadioButton .isSelected()){
						st.setJobPreferences(rdbtnNewRadioButton .getText());
					}
					else if(radioButton .isSelected()){
						st.setJobPreferences(radioButton .getText());
					}
					else if(radioButton_1 .isSelected()){
						st.setJobPreferences(radioButton_1 .getText());
					}
					else if(radioButton_2 .isSelected()){
						st.setJobPreferences(radioButton_2 .getText());
					}
					else if(radioButton_3.isSelected()){
						st.setJobPreferences(radioButton_3 .getText());
					}
					
				//	String aa=service1.findUserByName().
					st.setCompanyManager(pr1);
					service.add(st);
					JOptionPane.showMessageDialog(null, "Job Offer added");
			        
					new ListJobOffer().setVisible(true);
					
					
					
					
				}
			});
			
			Label label_2 = new Label("Sector");
			label_2.setBounds(333, 232, 46, 22);
			
			Label label_3 = new Label("Study Level");
			label_3.setBounds(643, 232, 71, 22);
			
			Label label = new Label("Title");
			label.setBounds(333, 154, 33, 22);
			
			Label label_4 = new Label("Country");
			label_4.setBounds(333, 307, 52, 22);
			
			Label label_5 = new Label("Skills");
			label_5.setBounds(333, 374, 38, 22);
			
			Label label_6 = new Label("Experience");
			label_6.setBounds(643, 307, 68, 22);
			
			Label label_7 = new Label("Job Preference");
			label_7.setBounds(333, 456, 88, 22);
			
			textField = new JTextField();
			textField.setBounds(333, 184, 214, 33);
			textField.setColumns(10);
			
			
			
			textField_1 = new JTextField();
			textField_1.setBounds(333, 260, 214, 33);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(643, 260, 214, 33);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(333, 335, 214, 33);
			textField_3.setColumns(10);
			
			textField_4 = new JTextField();
			textField_4.setBounds(643, 338, 214, 30);
			textField_4.setColumns(10);
			
			textField_5 = new JTextField();
			textField_5.setBounds(333, 396, 214, 33);
			textField_5.setColumns(10);
				contentPane.setLayout(null);
				contentPane.add(panel_1);
				contentPane.add(label);
				contentPane.add(textField);
				contentPane.add(label_1);
				contentPane.add(dateChooser);
				contentPane.add(label_2);
				contentPane.add(label_3);
				contentPane.add(textField_2);
				contentPane.add(label_4);
				contentPane.add(label_5);
				contentPane.add(label_6);
				contentPane.add(label_7);
				contentPane.add(rdbtnNewRadioButton);
				contentPane.add(radioButton_2);
				contentPane.add(radioButton_1);
				contentPane.add(radioButton);
				contentPane.add(radioButton_3);
				contentPane.add(button);
				contentPane.add(textField_5);
				contentPane.add(textField_1);
				contentPane.add(textField_4);
				contentPane.add(textField_3);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(47, 79, 79));
				panel.setBounds(292, 5, 610, 130);
				contentPane.add(panel);
				
				JLabel lblNewLabel_3 = new JLabel("Consult the Job Application");
				lblNewLabel_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						new ListJobApplication2().setVisible(true);
						
					}
				});
				lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				lblNewLabel_3.setForeground(Color.WHITE);
				
				JLabel lblNewLabel_4 = new JLabel("Home Page");
				lblNewLabel_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						new Login().setVisible(true);
					}
				});
				lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				lblNewLabel_4.setForeground(Color.WHITE);
				
				JLabel lblNewLabel_5 = new JLabel("X");
				lblNewLabel_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				lblNewLabel_5.setForeground(new Color(255, 20, 147));
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(326, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(575, Short.MAX_VALUE)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(8)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblNewLabel_4)
							.addContainerGap(34, Short.MAX_VALUE))
				);
				panel.setLayout(gl_panel);
	
		//initDataBindings();
		
		
		
	}
/*	protected void initDataBindings() {
		JComboBoxBinding<CompanyManager, List<CompanyManager>, JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE, companymanagers, comboBox_2);
		jComboBinding.bind();
		//
		BeanProperty<JComboBox, String> jComboBoxBeanProperty = BeanProperty.create("selectedItem.companyName");
		ObjectProperty<List<CompanyManager>> listObjectProperty = ObjectProperty.create();
		AutoBinding<JComboBox, String, List<CompanyManager>, List<CompanyManager>> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, comboBox_2, jComboBoxBeanProperty, companymanagers, listObjectProperty);
		autoBinding.bind();
	}*/

	public List<CompanyManager> getCompanymanagers() {
		return companymanagers;
	}

	public void setCompanymanagers(List<CompanyManager> companymanagers) {
		this.companymanagers = companymanagers;
	}
	}

