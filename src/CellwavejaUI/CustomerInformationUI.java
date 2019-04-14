package CellwavejaUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Core.Customer;
import Core.Product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomerInformationUI extends JPanel {

	private static final long serialVersionUID = 1L;
	CustomerInformation theCustomerInformation=new CustomerInformation();
	JTable table = new JTable();
	DefaultTableModel tmodel=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID"," Name","Email","telephone","Addresses",
			}
		);
	/**
	 * Create the panel.
	 */
	public CustomerInformationUI() {
		theCustomerInformation.attachObserver(Manager.getInstance());
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(viewCustomerInformation());
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		
		JLabel lblProductInventory = new JLabel("Customer Information");
		lblProductInventory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblProductInventory);
		
		JButton btnNewButton = new JButton("",new ImageIcon(InventoryUI.class.getResource("\\images\\add product.PNG")));
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			removeAll();
			add(new Addnewcustomertofile());
			revalidate();
					
		}
		});
		btnNewButton.setToolTipText("Add new Customer Information");	
		btnNewButton.setPreferredSize(new Dimension (30,30));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("",new ImageIcon(InventoryUI.class.getResource("\\images\\trashcanicon.PNG")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selrow=table.getSelectedRow();
				if (selrow>=0) {
					tmodel.removeRow(selrow);
					theCustomerInformation.deletecustomer(selrow);
					for (int i=0;i<table.getRowCount();i++) {
						tmodel.removeRow(i);
					}
					if(theCustomerInformation.gettheCustomerInformationFile().writetoCustomerInformationFile(theCustomerInformation.getCustomerInformation())==true) {
						for (int i=0; i<theCustomerInformation.getCustomerInformation().size(); i++){
							tmodel.addRow(theCustomerInformation.getCustomerInformation().get(i).print());
						}
					}
				}
			}
		});
		
		btnNewButton_1.setToolTipText("Remove Customer Information");
		btnNewButton_1.setPreferredSize(new Dimension(30,30));
		panel.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theCustomerInformation.getCustomerInformation().clear();
				for(int i=0; i<tmodel.getRowCount();i++) {
					theCustomerInformation.getCustomerInformation().add(new Core.Customer(tmodel.getValueAt(i, 0).toString(),tmodel.getValueAt(i, 1).toString() , tmodel.getValueAt(i, 2).toString(), tmodel.getValueAt(i, 3).toString(),
							tmodel.getValueAt(i, 4).toString()));
				}
				if(theCustomerInformation.gettheCustomerInformationFile().writetoCustomerInformationFile(theCustomerInformation.getCustomerInformation())==true) {
					System.out.println("updated");
					
				}
			}
			
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnUpdate);
		
		
		

	}
	public JTable viewCustomerInformation() {
		for(int x=0; x<table.getRowCount();x++) {
			tmodel.removeRow(x);
			
		}
		
		Collections.sort(theCustomerInformation.getCustomerInformation(),new Comparator<Customer>() {

			@Override
			public int compare(Customer cus0, Customer cus1) {
				// TODO Auto-generated method stub
				return cus0.getName().compareTo(cus1.getName());
			}
			
		}
		);
		for (int i=0; i<theCustomerInformation.getCustomerInformation().size(); i++){
			tmodel.addRow(theCustomerInformation.getCustomerInformation().get(i).print());
		}
		
		
		table.setModel(tmodel);
		return table;
	}

	

}
