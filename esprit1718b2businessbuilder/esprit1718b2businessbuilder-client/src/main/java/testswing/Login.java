package testswing;


import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.CompanyManager;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;
import tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	 private Context context;
	    private static String servicePath="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/UserService!tn.esprit.b2.esprit1718b2businessbuilder.services.UserServiceRemote";
	   private static String companyName;
	  public static User user;
	  static String firstName;
	  static String email1;
	  int xx, xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	


	public Login() {
		
	
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 714);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(5, 5, 334, 670);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		lblNewLabel_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				Login.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/images/bg.jpg")));
		lblNewLabel_3.setBounds(0, 0, 334, 281);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(55, 357, 248, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(55, 445, 248, 38);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(55, 311, 67, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(56, 408, 87, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setBounds(55, 550, 248, 38);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(241, 57, 83));
		
		JLabel lblNewLabel_2 = new JLabel("Sign Up");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(131, 525, 87, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddUser().setVisible(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				 try {
						context = new InitialContext();
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   
				UserServiceRemote  service = null;
		  
		             try {
						service = (UserServiceRemote) context.lookup(servicePath);
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		     
				String email=textField.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText(); 
				
			
					
					
				   if (service.login(email, password)!=null) {
	                    user=service.login(email, password);
	                    
				//	User user = service.login(email, password);
					if (user != null) {
						if (user instanceof Candidate) {
							
							System.out.println("i am a candidate "+user.getFirstName()+" "+user.getLastName());
							JOptionPane.showMessageDialog(null, "Welcome "+user.getFirstName()+" "+user.getLastName());
						
							new addjobapplication().setVisible(true);
				
						} else if (user instanceof CompanyManager){
							System.out.println("i am a company Manager"+user.getFirstName()+" "+user.getLastName());
							JOptionPane.showMessageDialog(null, "Welcome "+user.getFirstName()+" "+user.getLastName());
							
							new addJobOffer().setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "please verify your email or your password");
						}
						
						
			}}
					
					System.out.println("logged in...");
					
					
					System.out.println("open profile");
						
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(340, 5, 559, 142);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("x");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(529, 0, 20, 25);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		JLabel lblNewLabel_4 = new JLabel("Business Builder");
		lblNewLabel_4.setBounds(193, 11, 153, 38);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_4.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			new	List2JobOffer().setVisible(true);
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/images/imdds.png")));
		lblNewLabel_6.setBounds(373, 177, 208, 160);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(Login.class.getResource("/images/partnership-icon-small.png")));
		lblNewLabel_7.setBounds(677, 170, 201, 175);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(Login.class.getResource("/images/index.png")));
		lblNewLabel_8.setBounds(373, 389, 208, 181);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(Login.class.getResource("/images/247206-200.png")));
		lblNewLabel_9.setBounds(670, 392, 208, 175);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new StatJob().setVisible(true);
			}
		});
		lblNewLabel_10.setIcon(new ImageIcon(Login.class.getResource("/images/graphique-diagramme-statistique-diagramme-isométrique-plat-icon-3d-vecteur-illustration_csp45192125.jpg")));
		lblNewLabel_10.setBounds(557, 554, 146, 110);
		contentPane.add(lblNewLabel_10);
	}








	public static String getFirstName() {
		return firstName;
	}








	public static void setFirstName(String firstName) {
		Login.firstName = firstName;
	}
}
