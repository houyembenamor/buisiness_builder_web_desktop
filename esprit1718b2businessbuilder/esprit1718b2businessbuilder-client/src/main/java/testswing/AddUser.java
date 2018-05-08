package testswing;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.benamor.buisinessbuilder.services.candidate.CandidateServiceRemote;
import tn.benamor.businessbuilder.services.companymanager.CompanyManagerServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.UIManager;

public class AddUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private byte[] photo;
	  Clip buhClip;
	  private Context context;
	  int xx, xy;
	//  private static String servicePath="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/CandidateService!tn.benamor.buisinessbuilder.services.candidate.CandidateServiceRemote";
	    private static String servicePath2="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/CompanyManagerService!tn.benamor.businessbuilder.services.companymanager.CompanyManagerServiceRemote";
	    private static String servicePath="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/UserService!tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote";
	    private JTextField textField_8;
	    private JPasswordField textField_3;
	    private JTextField textField_6;
	    private JTextField textField_9;
	    private JTextField textField_10;
	    private JTextField textField_11;
	    private JTextField textField_12;
	    private JPanel panel;
	    private JButton btnShow;
	    private final JSeparator separator_1 = new JSeparator();
	    private JLabel lblNewLabel_6;
	    private JLabel lblNewLabel_8;
	    private JLabel lblNewLabel_11;
	    private JLabel lblNewLabel_12;
	    private JLabel lblNewLabel_14;
	    private JLabel lblNewLabel_15;
	    private JLabel lblNewLabel_16;
	    private JLabel link;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	
	
	
	  public void initData(String fn, String ln,String em,String us,String ct,  String phn,String Ct){
		  textField.setText(fn);
		  textField_1.setText(ln);
		  textField_2.setText(em);
		  textField_8.setText(us);
		  textField_3.setText(ct);
		  textField_4.setText(phn);
		  textField_5.setText(Ct);
	       
	        
	       //  type.setText(ty);
	
	
	  }
	
	public AddUser() {
		
		
		
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 702);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(326, 44, 301, 30);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(703, 44, 301, 30);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(326, 116, 301, 30);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(703, 195, 301, 30);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(326, 271, 301, 33);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(326, 19, 118, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(703, 19, 98, 14);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(326, 91, 86, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(703, 91, 98, 14);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(703, 170, 104, 14);
		
		JLabel lblNewLabel_5 = new JLabel("Nationality");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(326, 246, 86, 14);
		
		textField_8 = new JTextField();
		textField_8.setBounds(326, 195, 301, 30);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Username");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(326, 170, 86, 14);
		
		textField_3 = new JPasswordField();
		textField_3.setBounds(703, 116, 301, 30);
		
		JButton btnNewButton_2 = new JButton("Sign Up");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(241, 57, 83));
		btnNewButton_2.setBounds(504, 593, 319, 44);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  try {
						context = new InitialContext();
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   
				UserServiceRemote  service1 = null;
		  
		             try {
						service1= (UserServiceRemote  ) context.lookup(servicePath);
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		             if ((textField_12.getText().trim()).equalsIgnoreCase("company manager")){
		             CompanyManager cm =new CompanyManager(textField.getText(), textField_1.getText(), textField_2.getText(), textField_8.getText(), textField_3.getText(), Integer.valueOf(textField_4.getText()),
			        		  textField_5.getText(), textField_9.getText(), 
			        		  textField_10.getText(), textField_11.getText());
			          service1.save(cm);
			          new addJobOffer().setVisible(true);
					}  
		             else  if ((textField_12.getText().trim()).equalsIgnoreCase("candidate")){
			          Candidate cc=new Candidate(textField.getText(), textField_1.getText(), textField_2.getText(), textField_8.getText(), textField_3.getText(), Integer.valueOf(textField_4.getText()),
			        		  textField_5.getText(), textField_6.getText()
			        		  );
		             service1.save(cc);
		             new addjobapplication().setVisible(true);
		             }
		             
				
			}
		});
		
		textField_6 = new JTextField();
		textField_6.setBounds(703, 271, 301, 33);
		textField_6.setColumns(10);
		textField_6.setVisible(false);
		textField_9 = new JTextField();
		textField_9.setBounds(326, 410, 301, 33);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(703, 410, 301, 33);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(703, 344, 301, 33);
		textField_11.setColumns(10);
		 textField_9.setVisible(false);
    	 textField_10.setVisible(false);
    	 textField_11.setVisible(false);
		
		textField_12 = new JTextField();
		textField_12.setBounds(326, 344, 301, 33);
		textField_12.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textField_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField_1);
		contentPane.add(lblNewLabel_9);
		contentPane.add(lblNewLabel_3);
		contentPane.add(textField_3);
		contentPane.add(textField_8);
		contentPane.add(lblNewLabel_4);
		contentPane.add(textField_4);
		contentPane.add(lblNewLabel_5);
		contentPane.add(textField_5);
		contentPane.add(textField_6);
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		contentPane.add(textField_9);
		contentPane.add(textField_10);
		contentPane.add(textField_11);
		contentPane.add(btnNewButton_2);
		contentPane.add(textField_12);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 293, 744);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				AddUser.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx=arg0.getX();
				xy=arg0.getY();
			}
		});
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setBounds(0, 0, 293, 399);
		lblNewLabel_6.setIcon(new ImageIcon(AddUser.class.getResource("/images/bg.jpg")));
		panel.add(lblNewLabel_6);
		
		lblNewLabel_8 = new JLabel("Business Builder");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(84, 506, 147, 41);
		panel.add(lblNewLabel_8);
		
		btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  if ((textField_12.getText().trim()).equalsIgnoreCase("company manager")){
					  textField_9.setVisible(true);
					  textField_10.setVisible(true);
					  textField_11.setVisible(true);
					  lblNewLabel_14.setVisible(true);
					  lblNewLabel_15.setVisible(true);
					  lblNewLabel_16.setVisible(true);
					  AddUser.this.revalidate();
					  AddUser.this.repaint();
				  }
				  else  if ((textField_12.getText().trim()).equalsIgnoreCase("candidate")){
					  textField_6.setVisible(true);
					 
					  lblNewLabel_12.setVisible(true);
					
					  AddUser.this.revalidate();
					  AddUser.this.repaint();
				  }
			}
		});
		btnShow.setForeground(Color.WHITE);
		btnShow.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnShow.setBackground(new Color(241, 57, 83));
		btnShow.setBounds(864, 604, 73, 23);
		contentPane.add(btnShow);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(627, 72, -298, 2);
		contentPane.add(separator);
		separator_1.setBounds(504, 634, 319, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_10 = new JLabel("X");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblNewLabel_10.setForeground(new Color(241, 57, 83));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(980, 0, 24, 25);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Who you are?");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(326, 319, 98, 14);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Domain");
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(703, 246, 86, 14);
		contentPane.add(lblNewLabel_12);
		lblNewLabel_12.setVisible(false);
		lblNewLabel_14 = new JLabel("Company Name");
		lblNewLabel_14.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_14.setBounds(326, 388, 120, 14);
		contentPane.add(lblNewLabel_14);
		lblNewLabel_14.setVisible(false);
		lblNewLabel_15 = new JLabel("Company Address");
		lblNewLabel_15.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_15.setBounds(703, 385, 130, 14);
		contentPane.add(lblNewLabel_15);
		lblNewLabel_15.setVisible(false);
		lblNewLabel_16 = new JLabel("Description of the Company");
		lblNewLabel_16.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_16.setBounds(703, 319, 179, 14);
		contentPane.add(lblNewLabel_16);
		lblNewLabel_16.setVisible(false);
		JLabel link = new JLabel("Sign In");
		link.setBackground(Color.DARK_GRAY);
		link.setFont(UIManager.getFont("CheckBoxMenuItem.font"));
		link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Login().setVisible(true);
			}
		});
		link.setBounds(627, 555, 86, 14);
		contentPane.add(link);
	
	}
}
