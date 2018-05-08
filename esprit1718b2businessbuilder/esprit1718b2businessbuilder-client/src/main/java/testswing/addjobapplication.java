package testswing;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobApplication;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class addjobapplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	 private Context context;
	 int xx,xy;
	    private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/JobApplicationService!tn.benamor.businessbuilder.services.jobapplication.JobApplicationServiceRemote";
	    private static String servicePath1="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/UserService!tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addjobapplication frame = new addjobapplication();
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
	public addjobapplication() {
		setTitle("Job Application Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 584);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(300, 158, 197, 35);
		textField.setText("");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(595, 158, 235, 35);
		textField_1.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 315, 197, 35);
		
		JRadioButton radioButton = new JRadioButton("Part-Time");
		radioButton.setBounds(733, 327, 100, 23);
		
		
JRadioButton rdbtnNewRadioButton = new JRadioButton("Full-Time");
rdbtnNewRadioButton.setBounds(669, 412, 100, 23);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Temporary");
		rdbtnNewRadioButton_1.setBounds(586, 327, 100, 23);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Trainee");
		rdbtnNewRadioButton_3.setBounds(602, 374, 84, 23);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("from a distance");
		rdbtnNewRadioButton_4.setBounds(715, 374, 115, 23);
		
		JButton btnNewButton = new JButton("Add Job Application");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(241, 57, 83));
		btnNewButton.setBounds(441, 467, 225, 50);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
					context = new InitialContext();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 JobApplicationServiceRemote  service = null;
				 try {
					service = (JobApplicationServiceRemote) context.lookup(servicePath);
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
				 
				 
				 
				 
				
				
				
				String statut = textField.getText();
				String positionInterested = textField_1.getText();
			
				String country = textField_2.getText();

				
			
				String sector = textField_4.getText();
				//int	s = Integer.parseInt(textField_3.getText());
			
			String dateOfBegin=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				
				JobApplication st = new JobApplication();
				
			st.setStatut(statut);
			st.setPositionInterested(positionInterested);
		st.setCountry(country);
			st.setSector(sector);	
			
			st.setDateOfBegin(dateOfBegin);
			
			if(rdbtnNewRadioButton .isSelected()){
				st.setTypeContract(rdbtnNewRadioButton .getText());
			}
			if(rdbtnNewRadioButton_1 .isSelected()){
				st.setTypeContract(rdbtnNewRadioButton_1 .getText());
			}
			if(radioButton .isSelected()){
				st.setTypeContract(radioButton .getText());
			}
			if(rdbtnNewRadioButton_3 .isSelected()){
				st.setTypeContract(rdbtnNewRadioButton_3 .getText());
			}
			if(rdbtnNewRadioButton_4 .isSelected()){
				st.setTypeContract(rdbtnNewRadioButton_4 .getText());
			}
			 User pr=(User)Login.user;
				User pr1=service1.findUserById(pr.getIdUser());	
			st.setCandidate(pr1);
				service.add(st);
				
				JOptionPane.showMessageDialog(null, "Job Application added");
				new ListJobApplication().setVisible(true); 
				
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Statut");
		lblNewLabel.setBounds(300, 133, 84, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Which positions interest you");
		lblNewLabel_1.setBounds(594, 133, 236, 14);
		
		JLabel lblNewLabel_2 = new JLabel("When would you like to start a new job?");
		lblNewLabel_2.setBounds(300, 290, 235, 14);
		
		textField_2 = new JTextField();
		textField_2.setBounds(300, 238, 197, 35);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("What are the places you would like to work");
		lblNewLabel_3.setBounds(300, 206, 256, 28);
		
		JLabel lblNewLabel_4 = new JLabel("What types of contracts are you interested in?");
		lblNewLabel_4.setBounds(602, 290, 267, 14);
		
		textField_4 = new JTextField();
		textField_4.setBounds(595, 238, 235, 34);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Which sectors are you interested in?");
		lblNewLabel_5.setBounds(595, 213, 250, 14);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 267, 588);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				addjobapplication.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setBounds(0, 0, 267, 283);
		lblNewLabel_7.setIcon(new ImageIcon(addjobapplication.class.getResource("/images/bg.jpg")));
		panel.add(lblNewLabel_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(271, 5, 584, 117);
		panel_1.setBackground(new Color(47, 79, 79));
		
		JLabel lblNewLabel_8 = new JLabel("Display Job Offers");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new List2JobOffer().setVisible(true);
			}
		});
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_8.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_9 = new JLabel("Home Page");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
			}
		});
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_9.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_10 = new JLabel("X");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_10.setForeground(new Color(255, 20, 147));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
							.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(467, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel_8)
							.addGap(26)
							.addComponent(lblNewLabel_9))
						.addComponent(lblNewLabel_10))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Business Builder");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label.setBounds(34, 392, 160, 39);
		panel.add(label);
		contentPane.add(dateChooser);
		contentPane.add(lblNewLabel_4);
		contentPane.add(textField_2);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(radioButton);
		contentPane.add(rdbtnNewRadioButton_3);
		contentPane.add(rdbtnNewRadioButton_4);
		contentPane.add(lblNewLabel_5);
		contentPane.add(textField_4);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textField_1);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(panel_1);
	}
}
