package CellwavejaUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Core.Customer;
import Core.Product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Addnewcustomertofile extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	CustomerInformation theCustomerInformation=new CustomerInformation();
	private String customerid;
	private String customername;
	private String email;
	private String telephone;
	private String address;
	
	private JTextArea textArea_1Email;
	private JTextArea textAreaAddresses ;
	private JTextField textField_2TelephoneNumber;
	private JTextField textField_1CustomerName;
	private JTextField textFieldCustomerID;
	public Addnewcustomertofile() {
		theCustomerInformation.attachObserver(Manager.getInstance());
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterNewProducts = new JLabel("Add New Customer Information ");
		lblEnterNewProducts.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEnterNewProducts.setBounds(319, 13, 677, 66);
		panel.add(lblEnterNewProducts);
		
		JLabel lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerID.setBounds(319, 92, 136, 16);
		panel.add(lblCustomerID);
		
		JLabel lblCustomerName = new JLabel("Customer Name:\r\n");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerName.setBounds(319, 125, 147, 16);
		panel.add(lblCustomerName);
		
		JLabel lblTelephone = new JLabel("Telephone#:\r\n");
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelephone.setBounds(319, 154, 130, 21);
		panel.add(lblTelephone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(319, 294, 106, 27);
		panel.add(lblEmail);
		
		JLabel lbladdresses = new JLabel("Addresses:");
		lbladdresses.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbladdresses.setBounds(319, 184, 130, 25);
		panel.add(lbladdresses);
		
		textFieldCustomerID = new JTextField();
		textFieldCustomerID.setBounds(467, 86, 366, 22);
		panel.add(textFieldCustomerID);
		textFieldCustomerID.setColumns(10);
		
		textField_1CustomerName = new JTextField();
		textField_1CustomerName.setColumns(10);
		textField_1CustomerName.setBounds(467, 119, 366, 22);
		panel.add(textField_1CustomerName);
		
		textField_2TelephoneNumber = new JTextField();
		textField_2TelephoneNumber.setToolTipText("input telephone numbers as numbers\r\n");
		textField_2TelephoneNumber.setColumns(10);
		textField_2TelephoneNumber.setBounds(467, 153, 366, 22);
		panel.add(textField_2TelephoneNumber);
		
		textAreaAddresses = new JTextArea();
		textAreaAddresses.setBounds(467, 187, 373, 85);
		panel.add(textAreaAddresses);
		
		 textArea_1Email = new JTextArea();
		textArea_1Email.setToolTipText("in put transaction number");
		textArea_1Email.setBounds(467, 298, 373, 101);
		panel.add(textArea_1Email);
		
		JButton btnSaveCustomerInformation = new JButton("Save Customer Information",new ImageIcon(addproductinformationGUI.class.getResource("images\\saveicon.PNG")));
		btnSaveCustomerInformation.setBackground(Color.decode("#BEE5F9"));
		btnSaveCustomerInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (testUserInput()==true) {
					customerid=textFieldCustomerID.getText();
					customername=textField_1CustomerName.getText();
					email=textArea_1Email.getText();
					telephone=textField_2TelephoneNumber.getText();
					address=textAreaAddresses.getText();
					removeAll();
					theCustomerInformation.getCustomerInformation().add(new Core.Customer(customerid,customername,address,telephone,email));
					if (theCustomerInformation.gettheCustomerInformationFile().writetoCustomerInformationFile(theCustomerInformation.getCustomerInformation())==true) {
						theCustomerInformation.notifyObserversofSuccessfuladdition(3);
					}
					add(new CustomerInformationUI(),BorderLayout.CENTER);
					revalidate();
					
				}	
			}
		});
		btnSaveCustomerInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSaveCustomerInformation.setBounds(581, 463, 337, 101);
		panel.add(btnSaveCustomerInformation);
		
		JButton btnCancel = new JButton("Cancel\r\n",new ImageIcon(addproductinformationGUI.class.getResource("images\\cancelicon.PNG")));
		btnCancel.setBackground(Color.decode("#BEE5F9"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(new CustomerInformationUI(),BorderLayout.CENTER);
				revalidate();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBounds(319, 463, 185, 100);
		panel.add(btnCancel);
		
		
	}
	public boolean testUserInput() {
	
		boolean success=true;
		
		if(textFieldCustomerID.getText().isEmpty()||textField_1CustomerName.getText().isEmpty()||textField_2TelephoneNumber.getText().isEmpty()||textAreaAddresses.getText().isEmpty()||textArea_1Email.getText().isEmpty()) {
			success=false;
			theCustomerInformation.notifyObserverOfErrorsInAddingProduct(7);
		}
		for (int i=0; i<theCustomerInformation.getCustomerInformation().size(); i++){
			if(textField_1CustomerName.getText().equals(theCustomerInformation.getCustomerInformation().get(i).getName()) &&textFieldCustomerID.getText().equals(theCustomerInformation.getCustomerInformation().get(i).getCustomerid())) {
				success=false;
				theCustomerInformation.notifyObserverOfErrorsInAddingProduct(11);
			}
		}
		return success;
	}
}
