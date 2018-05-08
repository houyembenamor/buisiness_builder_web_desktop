package testswing;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import tn.benamor.businessbuilder.services.JobOfferServiceRemote;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ApplyJobOffer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JobOffer tran;
	static int x;
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
					ApplyJobOffer frame = new ApplyJobOffer(x);
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
	public ApplyJobOffer(int idOffer) {
		x=idOffer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 532);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		
		
		
		tran= service.findJobOfferById(x);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBounds(414, 213, 55, 14);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setBounds(414, 262, 55, 14);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setBounds(414, 306, 55, 14);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setBounds(414, 354, 55, 14);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setBounds(610, 213, 55, 14);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_6.setBounds(610, 262, 55, 14);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_7.setBounds(610, 306, 55, 14);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setForeground(new Color(0, 0, 128));
		lblNewLabel_8.setBounds(613, 354, 55, 14);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setBounds(324, 213, 51, 14);
		
		JLabel lblNewLabel_9 = new JLabel("Post Date:");
		lblNewLabel_9.setBounds(324, 262, 80, 14);
		
		JLabel lblNewLabel_10 = new JLabel("Sector:");
		lblNewLabel_10.setBounds(324, 306, 51, 14);
		
		JLabel lblNewLabel_11 = new JLabel("Study Level:");
		lblNewLabel_11.setBounds(324, 354, 80, 14);
		
		JLabel lblNewLabel_12 = new JLabel("Country:");
		lblNewLabel_12.setBounds(521, 213, 79, 14);
		
		JLabel lblNewLabel_13 = new JLabel("Experience:");
		lblNewLabel_13.setBounds(521, 262, 79, 14);
		
		JLabel lblNewLabel_14 = new JLabel("Skills:");
		lblNewLabel_14.setBounds(521, 306, 49, 14);
		
		JLabel lblNewLabel_15 = new JLabel("Job Preferences:");
		lblNewLabel_15.setBounds(521, 354, 82, 14);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBackground(new Color(241, 57, 83));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(455, 425, 136, 39);
		
		
		
		
		
		tran= service.findJobOfferById(x);
		
		
		
		//String	lab1= String.valueOf(tran.getIdOffer());
		String	lab2= tran.getTitle();
		String	lab3= tran.getPostDate();
		String lab4=tran.getSector();
		//String lab5=String.valueOf(tran.getBirthDate());
		String lab6=tran.getStudyLevel();
		String lab7=tran.getCountry();
		String lab8=tran.getExperience();
		String lab9=tran.getSkills();
		//String lab10=String.valueOf(tran.getIssueDate());
		String lab11=tran.getJobPreferences();
		//byte[] lab12=tran.getPicture();
		
		//lblNewLabel .setText(lab1);
		lblNewLabel_1.setText(lab2);
		lblNewLabel_2.setText(lab3);
		lblNewLabel_3.setText(lab4);
		lblNewLabel_4.setText(lab6);
		lblNewLabel_5.setText(lab7);
		lblNewLabel_6.setText(lab8);
		lblNewLabel_7.setText(lab9);
		lblNewLabel_8.setText(lab11);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_9);
		contentPane.add(lblNewLabel_10);
		contentPane.add(lblNewLabel_11);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_15);
		contentPane.add(lblNewLabel_14);
		contentPane.add(lblNewLabel_12);
		contentPane.add(lblNewLabel_13);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_8);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 285, 493);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				ApplyJobOffer.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		lblNewLabel_16.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_16.setIcon(new ImageIcon(ApplyJobOffer.class.getResource("/images/bg.jpg")));
		lblNewLabel_16.setBounds(0, 0, 285, 301);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Business Builder");
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_17.setBounds(21, 310, 148, 38);
		panel.add(lblNewLabel_17);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(284, 0, 423, 145);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_18 = new JLabel("Back to List Of Job Offers");
		lblNewLabel_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new List2JobOffer().setVisible(true);
			}
		});
		lblNewLabel_18.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setBounds(10, 21, 198, 14);
		panel_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("X");
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_19.setForeground(new Color(255, 20, 147));
		lblNewLabel_19.setBounds(384, 11, 29, 24);
		panel_1.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Home Page");
		lblNewLabel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
			}
		});
		lblNewLabel_20.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_20.setForeground(Color.WHITE);
		lblNewLabel_20.setBounds(10, 59, 135, 14);
		panel_1.add(lblNewLabel_20);
		
		
		//ImageIcon lab12 = new ImageIcon(PicURL);

		//label_1.setIcon(lab12);
		
		//int aa= Integer.parseInt(lab1);
	}
}
