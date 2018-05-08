package testswing;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.benamor.buisinessbuilder.services.candidate.CandidateServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;

public class Profile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int x;
	 Candidate c;
	private JPanel contentPane;
	private Context context;
    private static String servicePath="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/CandidateService!tn.benamor.buisinessbuilder.services.candidate.CandidateServiceRemote";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile(x);
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
	public Profile(int idUser) {
		x=idUser;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu(" Job Offer");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmConsultJobOffers = new JMenuItem("Consult Job Offers");
		mnNewMenu.add(mntmConsultJobOffers);
		
		JMenu mnJobApplication = new JMenu("Job Application");
		menuBar.add(mnJobApplication);
		
		JMenuItem mntmAddJobApplication = new JMenuItem("Add Job Application");
		mnJobApplication.add(mntmAddJobApplication);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_6))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_7))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		

        try {
			context = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	CandidateServiceRemote  service = null;

        try {
			service = (CandidateServiceRemote) context.lookup(servicePath);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // Candidate c=service.findCandidateByEmail(Login.getEmail());
        c=service.findCandidateById(x);
        String l1=c.getFirstName();
        String l2=c.getLastName();
        String l3=c.getEmail();
        String l4=c.getUserName();
        String l5=c.getPassword();
        int l6=c.getPhoneNumber();
        String l7=c.getNationality();
        String l8=c.getDomain();
        
        
        
        
        lblNewLabel .setText("First Name: "+l1);
        lblNewLabel_1.setText("Last Name: "+l2);
        lblNewLabel_2.setText("Email: "+l3);
        lblNewLabel_3.setText("Username: "+l4);
        lblNewLabel_4.setText("Password: "+l5);
        lblNewLabel_5.setText("Phone Number: "+l6);
        lblNewLabel_6.setText("Nationality: "+l7);
        lblNewLabel_7.setText("Domain: "+l8);
      
		
	}
}
