package CellwavejaUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Core.Transaction;

import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculateTaxesUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	TransactionInformation theTransactionInformation=new TransactionInformation();
	/**
	 * Create the panel.
	 */
	public CalculateTaxesUI() {
		setLayout(null);
		
		JLabel lblCalculateTaxes = new JLabel("Calculate The GCT to be paid for a specific Month");
		lblCalculateTaxes.setBounds(0, 0, 511, 22);
		lblCalculateTaxes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCalculateTaxes.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCalculateTaxes);
		
		JLabel lblEnterCurrentPercentage = new JLabel("Enter current G.C.T rate:");
		lblEnterCurrentPercentage.setBounds(0, 188, 272, 30);
		lblEnterCurrentPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterCurrentPercentage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblEnterCurrentPercentage);
		
		textField = new JTextField();
		textField.setToolTipText("Enter as a a number e.g 16.5 or 17.5");
		textField.setBounds(300, 190, 116, 30);
		add(textField);
		textField.setColumns(10);
		
		
		JLabel lblMonthYear = new JLabel("Enter the Month-Year of G.C.T to be Calculated:");
		lblMonthYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonthYear.setBounds(12, 148, 344, 30);
		add(lblMonthYear);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter in the format mm-yyyy or 02-2018 ");
		textField_1.setBounds(363, 153, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);


		
		JButton btnCalculateGCT = new JButton("Calculate G.C.T ");
		btnCalculateGCT.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCalculateGCT.setBounds(141, 252, 181, 30);
		add(btnCalculateGCT);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(347, 314, 116, 21);
		add(lblNewLabel_1);
		
		JLabel lblAmountToBe = new JLabel("Amount To Be Paid:");
		lblAmountToBe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmountToBe.setBounds(97, 316, 175, 16);
		add(lblAmountToBe);
		
		
		btnCalculateGCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String monthYear=textField_1.getText();
				Float taxRate=Float.parseFloat(textField.getText());
				
				lblNewLabel_1.setText("$"+calculateTaxes(monthYear,taxRate)); 
				}
		});
		
	}
	  public String calculateTaxes(String my,float tr) {
		    Float totalGCT=(float)0;
			String tMonthYear;
			for (int i=0; i<theTransactionInformation.getTransactionInformation().size(); i++){
				tMonthYear=theTransactionInformation.getTransactionInformation().get(i).getTransactionDate();
				if (tMonthYear.contains(my)){
					totalGCT+=(float)(theTransactionInformation.getTransactionInformation().get(i).getCashtendered()*tr/100);
				}
			}
			return String.valueOf(totalGCT); 
			}
	

	}
