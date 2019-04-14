package CellwavejaUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Core.Product;
import Core.Transaction;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class profitLostUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	TransactionInformation theTransactionInformation=new TransactionInformation();
	Inventory theInventory=new Inventory();
	/**
	 * Create the panel.
	 */
	public profitLostUI() {
		setLayout(null);
		
		JLabel lblCalculateProfitloss = new JLabel("Calculate Profit/Loss");
		lblCalculateProfitloss.setBounds(0, 0, 450, 22);
		lblCalculateProfitloss.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculateProfitloss.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCalculateProfitloss);
		
		JLabel lblEnterSerialNumber = new JLabel("Enter Model number:");
		lblEnterSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterSerialNumber.setBounds(12, 69, 168, 30);
		add(lblEnterSerialNumber);
		
		textField = new JTextField();
		textField.setBounds(183, 71, 189, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblProfitloss = new JLabel("Profit/Loss =");
		lblProfitloss.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProfitloss.setBounds(12, 222, 133, 30);
		add(lblProfitloss);
		
		JLabel lblresult = new JLabel("\"Result\"");
		lblresult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblresult.setBounds(157, 222, 245, 30);
		add(lblresult);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((float)calculateprofit_Loss(textField.getText(),textField_1.getText())==0){
					lblresult.setText("Product was not sold ");
				}else {
					lblresult.setText(String.valueOf("$"+calculateprofit_Loss(textField.getText(),textField_1.getText())));
				}
			}
		});
		btnCalculate.setBounds(111, 177, 205, 32);
		add(btnCalculate);
		
		JLabel lblEnterProductName = new JLabel("Enter Product name:");
		lblEnterProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterProductName.setBounds(12, 127, 168, 33);
		add(lblEnterProductName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 127, 189, 29);
		add(textField_1);
		textField_1.setColumns(10);

	}
	 public float calculateprofit_Loss(String model,String name) {
			float costPrice=0;
			float pL = 0;
			
			for (int x=0;x<theInventory.getProductInformation().size();x++) {
				String m = theInventory.getProductInformation().get(x).getModelNumber();
				String p= theInventory.getProductInformation().get(x).getProductName();
				if (m.equals(model) && p.equals(name) ) {
					costPrice=theInventory.getProductInformation().get(x).getCostPrice();
				}
			}
			for ( int i =0;i<theTransactionInformation.getTransactionInformation().size(); i++) {
				String m = theTransactionInformation.getTransactionInformation().get(i).getProductModelNumber();
				String p= theTransactionInformation.getTransactionInformation().get(i).getProductName();
				if (m.equals(model) && p.equals(name) ) {
					pL +=  theTransactionInformation.getTransactionInformation().get(i).getCashtendered()- costPrice;
				} 
			}
			return pL;
		}

}