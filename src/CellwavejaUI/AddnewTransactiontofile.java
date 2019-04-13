package CellwavejaUI;
import Core.*;

import Util.DateUtil;

import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Date;
import java.text.*;
import java.util.*;

public class AddnewTransactiontofile extends JPanel {
	private static final long serialVersionUID = 1L;
	Inventory theInventory=new Inventory();
	TransactionInformation theTransactionInformation=new TransactionInformation();
	private String transactionDate;
	private String cashOrCard;
    private String customerId;
    private String customerName;
    private String productModelNumber;
    private String productName;
    private String productType;
	private String productColour;
	private Float cashTendered;
	private int quantityPurchased;
	
	private JTextField textField_CashTendered;
	private JTextField textField;
	private JTextField textField_7CashOrCard;
	private JTextField textField_6Colour;
	private JTextField textField_4ProductType;
	private JTextField textField_2ProductName;
	private JTextField textField_7ProductModelNumber;
	private JTextField textField_1CustomerName; 
	private JTextField textFieldCustomerID;
	/**
	 * Create the panel.
	 */
	public AddnewTransactiontofile() {
		theInventory.attachObserver(Manager.getInstance());
		theTransactionInformation.attachObserver(Manager.getInstance());
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEnterNewProducts = new JLabel("Add New Transaction ");
		lblEnterNewProducts.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEnterNewProducts.setBounds(319, 13, 677, 66);
		panel.add(lblEnterNewProducts);
		
		JLabel lblCustomerID = new JLabel("(Optional)Customer ID:");
		lblCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerID.setBounds(235, 92, 220, 21);
		panel.add(lblCustomerID);
		
		JLabel lblCustomerName = new JLabel("(Optional) Customer Name:\r\n");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerName.setBounds(224, 137, 231, 21);
		panel.add(lblCustomerName);

		JLabel lblProductModelnumber = new JLabel("Product Model#");
		lblProductModelnumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductModelnumber.setBounds(319, 182, 130, 16);
		panel.add(lblProductModelnumber);
		
		JLabel lblProductName = new JLabel("Product Name:\r\n");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductName.setBounds(319, 230, 130, 21);
		panel.add(lblProductName); 
		
		JLabel lblProductType = new JLabel("Product Type:");
		lblProductType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductType.setBounds(319, 275, 136, 27);
		panel.add(lblProductType);
		
		JLabel lblColour= new JLabel("Colour:");
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblColour.setBounds(319, 315, 107, 27);
		panel.add(lblColour);
		
		JLabel lblQuantity = new JLabel("Paid with:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantity.setBounds(319, 350, 130, 25);
		panel.add(lblQuantity);

		/*JTextField textField_CashTendered = new JTextField();
		textField_CashTendered.setToolTipText("Enter a number e.g 14 or 20\r\n");
		textField_CashTendered.setColumns(10);
		textField_CashTendered.setBounds(467, 367, 366, 22);
		panel.add(textField_CashTendered);*/
		
		textFieldCustomerID = new JTextField();
		textFieldCustomerID.setBounds(467, 91, 366, 22);
		panel.add(textFieldCustomerID);
		textFieldCustomerID.setColumns(10);
		
		textField_1CustomerName = new JTextField();
		textField_1CustomerName.setColumns(10);
		textField_1CustomerName.setBounds(467, 136, 366, 22);
		panel.add(textField_1CustomerName);

		textField_7ProductModelNumber = new JTextField();
		textField_7ProductModelNumber.setBounds(467, 181, 366, 22);
		panel.add(textField_7ProductModelNumber);
		textField_7ProductModelNumber.setColumns(10);
		
		textField_2ProductName = new JTextField();
		textField_2ProductName.setColumns(10);
		textField_2ProductName.setBounds(467, 230, 366, 22);
		panel.add(textField_2ProductName);
		
		textField_4ProductType = new JTextField();
		textField_4ProductType.setColumns(10);
		textField_4ProductType.setBounds(467, 275, 366, 22);
		panel.add(textField_4ProductType);
		
		textField_6Colour = new JTextField();
		textField_6Colour.setToolTipText("");
		textField_6Colour.setColumns(10);
		textField_6Colour.setBounds(468, 315, 366, 22);
		panel.add(textField_6Colour);

		textField_7CashOrCard = new JTextField();
		textField_7CashOrCard.setToolTipText("Enter a number e.g 14 or 20\r\n");
		textField_7CashOrCard.setColumns(10);
		textField_7CashOrCard.setBounds(467, 353, 366, 22);
		panel.add(textField_7CashOrCard);
		
		JButton btnNewButton = new JButton("Save Transaction");//,new ImageIcon(addproductinformationGUI.class.getResource("/images/saveicon.PNG")));
		btnNewButton.setBackground(Color.decode("#BEE5F9"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product thePurProduct=null;
				
				//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				//Calendar cal = Calendar.getInstance();
				//transactionDate = (dateFormat.format(cal.getTime()));
				//String today = DateUtil.today();
				//transactionDate = DateUtil.stringToDate(today);
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				transactionDate=df.format(new Date());
			
				if (testUserInput()==true) {
					int transactionNum = theTransactionInformation.getTransactionInformation().size()+1;

					cashOrCard = textField_7CashOrCard.getText();
					customerId = textFieldCustomerID.getText();
					customerName = textField_1CustomerName.getText();
					productModelNumber = textField_7ProductModelNumber.getText();
					productName = textField_2ProductName.getText();
					productType = textField_4ProductType.getText();
					productColour = textField_6Colour.getText();
					cashTendered = Float.valueOf(textField_CashTendered.getText());
					quantityPurchased=Integer.parseInt(textField.getText());
					for (int i=0; i<theInventory.getProductInformation().size(); i++){
						if(textField_2ProductName.getText().equals(theInventory.getProductInformation().get(i).getProductName())&&textField_7ProductModelNumber.getText().equals(theInventory.getProductInformation().get(i).getModelNumber())&&textField_4ProductType.getText().equals(theInventory.getProductInformation().get(i).getProductType())&&textField_6Colour.getText().equals(theInventory.getProductInformation().get(i).getColour())) {
							thePurProduct= theInventory.getProductInformation().get(i);
							break;
						}
					}
					for (Product p:theInventory.getProductInformation()) {
						if(p.equals(thePurProduct)) {
							p.setQuantity(thePurProduct.getQuantity()-quantityPurchased);
							break;
						}
					}
					removeAll();
					
					theTransactionInformation.getTransactionInformation().add(new Transaction(transactionNum, transactionDate, cashOrCard, customerId, customerName, productModelNumber,
										productName, productType, productColour, cashTendered,quantityPurchased));
					if(theTransactionInformation.getTheTransactionInformationFile().writeToTransactionFile((theTransactionInformation.getTransactionInformation()))==true && theInventory.getInventoryFile().writeToProductFile((theInventory.getProductInformation()))) {
						theTransactionInformation.notifyObserversofSuccessfuladdition(2);;
					}
					add(new TransactionInformationUI(),BorderLayout.CENTER);
					revalidate();
				}	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(627, 476, 258, 101);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel\r\n");//,new ImageIcon(addproductinformationGUI.class.getResource("/images/cancelicon.PNG")));
		btnNewButton_1.setBackground(Color.decode("#BEE5F9"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(new TransactionInformationUI(),BorderLayout.CENTER);
				revalidate();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(320, 476, 185, 100);
		panel.add(btnNewButton_1);
		
		textField_CashTendered = new JTextField();
		textField_CashTendered.setToolTipText("Enter value as a Number e.g 14.00 or 600.00\"\r\n");
		textField_CashTendered.setColumns(10);
		textField_CashTendered.setBounds(467, 388, 366, 22);
		panel.add(textField_CashTendered);
		
		JLabel lblCashtendered = new JLabel("CashTendered:");
		lblCashtendered.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCashtendered.setBounds(319, 388, 130, 25);
		panel.add(lblCashtendered);
		
		JLabel lblQuantity_1 = new JLabel("Quantity Purchased :");
		lblQuantity_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantity_1.setBounds(247, 426, 179, 19);
		panel.add(lblQuantity_1);
		
		textField = new JTextField();
		textField.setToolTipText("Enter value as a Number e.g 14. or 600\"\r\n");
		textField.setColumns(10);
		textField.setBounds(467, 423, 366, 22);
		panel.add(textField);
		
		
		
		
		

	
	}
	public boolean testUserInput() {
		int right=0;
		Product thePurProduct=null;
		
		
		boolean success=true;		
		if(textField_2ProductName.getText().isEmpty()||textField_7CashOrCard.getText().isEmpty()||textField_4ProductType.getText().isEmpty()||textField_6Colour.getText().isEmpty()) {
			success=false;
			theTransactionInformation.notifyObserverOfErrorsInAddingProduct(7);
		}
		for (int i=0; i<theInventory.getProductInformation().size(); i++){
			if(textField_2ProductName.getText().equals(theInventory.getProductInformation().get(i).getProductName())&&textField_7ProductModelNumber.getText().equals(theInventory.getProductInformation().get(i).getModelNumber())&&textField_4ProductType.getText().equals(theInventory.getProductInformation().get(i).getProductType())&&textField_6Colour.getText().equals(theInventory.getProductInformation().get(i).getColour())) {
				right=1;
				thePurProduct= theInventory.getProductInformation().get(i);
				if(theInventory.getProductInformation().get(i).getQuantity()<=0) {
					right=2;
				}
				break;
			}
		}
		if(right==0){
			success=false;
			theInventory.notifyObserverOfErrorsInAddingProduct(9);
		}
		if(right==2) {
			success=false;
			theInventory.notifyObserverOfErrorsInAddingProduct(10);
		}
		return success;
	}
}
