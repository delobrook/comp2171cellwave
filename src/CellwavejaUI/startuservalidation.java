package CellwavejaUI;
import Core.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.*;

//import com.sun.jndi.ldap.ManageReferralControl;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class startuservalidation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Username_field;
	private JPasswordField passwordField;
	private String testmanager_username;
	private String testmanager_password;
	Manager m=Manager.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startuservalidation frame = new startuservalidation();
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
	public startuservalidation() {

		
	
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366,768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FAFAFA"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#824CB3"));
		panel.setBounds(0, 0, 666, 721);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(12, 73, 678, 505);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(startuservalidation.class.getResource("\\images\\Opera Snapshot_2018-11-12_142622_www.instagram.com.png")));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(803, 300, 408, 35);
		contentPane.add(passwordField);
		
		
		Username_field = new JTextField();
		Username_field.setBounds(801, 162, 408, 35);
		contentPane.add(Username_field);
		Username_field.setColumns(10);
		

		Button signinbutton = new Button("Sign In");
		signinbutton.setBounds(801, 435, 285, 68);
		contentPane.add(signinbutton);
		signinbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testmanager_password = String.valueOf(passwordField.getPassword());
				testmanager_username = String.valueOf(Username_field.getText());
				grantSystemAccess(testmanager_username,testmanager_password);
			}
					
		});
		signinbutton.setFont(new Font("Dialog", Font.BOLD, 16));
		signinbutton.setForeground(Color.WHITE);
		signinbutton.setBackground(Color.decode("#280847"));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(801, 195, 408, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("USERNAME:");
		lblNewLabel.setBounds(801, 121, 408, 28);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(803, 271, 139, 16);
		contentPane.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JSeparator password_separator_1 = new JSeparator();
		password_separator_1.setBounds(801, 333, 271, 2);
		contentPane.add(password_separator_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(665, 0, 683, 77);
		contentPane.add(panel_1);
		panel_1.setBackground(Color.decode("#8CD4F0"));
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(665, 568,683, 153);
		contentPane.add(panel_2);
		panel_2.setBackground(Color.decode("#8CD4F0"));
	}

	public String getinputPassword(){
		return testmanager_password;
	}

	public String getinputUsername(){
		return testmanager_username;
	}
	public void grantSystemAccess(String inputUsername,String inputPassword) {
		
		if (m.login(inputUsername, inputPassword)) {
		
				Functionsui f=new Functionsui();	
				setContentPane(f);
				revalidate();
		}
	}	
	
}

