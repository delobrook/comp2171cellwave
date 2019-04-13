package CellwavejaUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Core.Product;
import Core.Transaction;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TransactionInformationUI extends JPanel {
	TransactionInformation theTransactionInformation=new TransactionInformation();
	private static final long serialVersionUID = 1L;
	JTable table = new JTable();
	DefaultTableModel tmodel=new DefaultTableModel();
	/**
	 * Create the panel.
	 */
	public TransactionInformationUI() {
		theTransactionInformation.attachObserver(Manager.getInstance());
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(viewTransactionInformation());
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		
		JLabel lblProductInventory = new JLabel("Transactions");
		lblProductInventory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblProductInventory);
		
		JButton btnNewButton = new JButton("",new ImageIcon(InventoryUI.class.getResource("\\images\\add product.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(new AddnewTransactiontofile(),BorderLayout.CENTER);
				revalidate();
			}
		});
		btnNewButton.setToolTipText("Add new transaction");	
		btnNewButton.setPreferredSize(new Dimension (30,30));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("",new ImageIcon(InventoryUI.class.getResource("\\images\\trashcanicon.PNG")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selrow=table.getSelectedRow();
				if (selrow>=0) {
					tmodel.removeRow(selrow);
					theTransactionInformation.deleteTransaction(selrow);
					if(theTransactionInformation.getTheTransactionInformationFile().writeToTransactionFile(theTransactionInformation.getTransactionInformation())==true) {
						for (int i=0; i<theTransactionInformation.getTransactionInformation().size(); i++){
							tmodel.addRow(theTransactionInformation.getTransactionInformation().get(i).print());
						}
					}
				}
				
			}
		});
		btnNewButton_1.setToolTipText("Remove Transaction from file");
		btnNewButton_1.setPreferredSize(new Dimension(30,30));
		panel.add(btnNewButton_1);
	}
	public JTable viewTransactionInformation() {
		tmodel.addColumn("Transaction #");
		tmodel.addColumn("Customer ID");
		tmodel.addColumn("Product Model #");
		tmodel.addColumn("Product Name");
		tmodel.addColumn("Product Type");
		tmodel.addColumn("Product Colour");
		tmodel.addColumn("Date & Time");
		tmodel.addColumn("Cash tendered");
		tmodel.addColumn("Cash || Card");
		tmodel.addColumn("Quantity Purchased");
		
		for(int x=0; x<table.getRowCount();x++) {
				tmodel.removeRow(x);
				
		}
	
		Collections.sort(theTransactionInformation.getTransactionInformation(),new Comparator<Transaction>() {
		
			@Override
			public int compare(Transaction tran0, Transaction tran1) {
				// TODO Auto-generated method stub
				return Integer.valueOf(tran1.getTransactionNumber()).compareTo(tran0.getTransactionNumber());
			}});
		for (int i=0; i<theTransactionInformation.getTransactionInformation().size(); i++){
			tmodel.addRow(theTransactionInformation.getTransactionInformation().get(i).print());
		}
	
		table.setModel(tmodel);
		return table;
	}
}
