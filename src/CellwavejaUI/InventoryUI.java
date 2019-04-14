package CellwavejaUI;
import Core.*;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import javax.swing.Popup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	ArrayList <String> productimagename;
	DefaultTableModel tmodel=new DefaultTableModel();
	Inventory theInventory=new Inventory();
	int selrow;
	/**
	 * Create the panel.
	 */
	public InventoryUI() {
		theInventory.attachObserver(Manager.getInstance());
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(viewInventory());
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		
		JLabel lblProductInventory = new JLabel("Product Inventory");
		lblProductInventory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblProductInventory);
		
		JButton btnNewButton = new JButton("",new ImageIcon(InventoryUI.class.getResource("images\\add product.PNG")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(new addproductinformationGUI());
				revalidate();
			}
		});
		btnNewButton.setToolTipText("Add new product to inventory");	
		btnNewButton.setPreferredSize(new Dimension (30,30));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("",new ImageIcon(InventoryUI.class.getResource("\\images\\trashcanicon.PNG")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selrow=table.getSelectedRow();
				if (selrow>=0) {
					tmodel.removeRow(selrow);
					theInventory.deleteProduct(selrow);
					productimagename.remove(selrow);
					for (int i=0;i<table.getRowCount();i++) {
						tmodel.removeRow(i);
					}
					if(theInventory.getInventoryFile().writeToProductFile(theInventory.getProductInformation())==true) {
						for (int i=0; i<theInventory.getProductInformation().size(); i++){
							tmodel.addRow(theInventory.getProductInformation().get(i).print());
						}
					}
				}
				
			}
		});
		btnNewButton_1.setToolTipText("Remove Product from inventory");
		btnNewButton_1.setPreferredSize(new Dimension(30,30));
		panel.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("Update");//updates information
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theInventory.clearProductInformation();
				for(int i=0; i<tmodel.getRowCount();i++) {
					theInventory.addNewProduct(Product.createProduct(tmodel.getValueAt(i, 0).toString(),tmodel.getValueAt(i, 1).toString() , tmodel.getValueAt(i, 2).toString(), tmodel.getValueAt(i, 7).toString(),
							Float.parseFloat(tmodel.getValueAt(i, 5).toString()),Float.parseFloat( tmodel.getValueAt(i, 6).toString()),Integer.parseInt(tmodel.getValueAt(i, 3).toString()),productimagename.get(i), tmodel.getValueAt(i, 4).toString()));
				
				}
				if(theInventory.getInventoryFile().writeToProductFile((theInventory.getProductInformation()))==true) {
					System.out.println("updated");
					
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setToolTipText("update file with changes you made");
		panel.add(btnUpdate);
		
		JButton btnSellProduct = new JButton("Sell This Product");//updates information
		btnSellProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selrow=table.getSelectedRow();
				if (selrow==-1) {
					JOptionPane.showMessageDialog(null, "SELECT A PRODUCT TO SELL", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}else {
					removeAll();
					Product selProduct=theInventory.getProductInformation().get(selrow);
					add(new AddnewTransactiontofile(selProduct.getModelNumber(),selProduct.getProductName(),selProduct.getColour(),selProduct.getProductType()));
					revalidate();
				}
			}
		});
		btnSellProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSellProduct.setToolTipText("Select product to make a transaction");
		panel.add(btnSellProduct);
		

	}
	public JTable viewInventory(){
		table = new JTable();
		

		tmodel.addColumn("Model#");
		tmodel.addColumn("Product Name");
		tmodel.addColumn("Product Type");
		tmodel.addColumn("Quantity");
		tmodel.addColumn("Colour");
		tmodel.addColumn("Cost Price");
		tmodel.addColumn("Selling Price");
		tmodel.addColumn("Description");
		for(int x=0; x<table.getRowCount();x++) {
			tmodel.removeRow(x);
			
		}
		Collections.sort(theInventory.getProductInformation(),new Comparator<Product>(){

		@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o1.getProductName().compareTo(o2.getProductName());
			}
			
		});
		productimagename =new ArrayList<String>();
		for(Product p:theInventory.getProductInformation()) {
			productimagename.add(p.getImageName());
		}
		for (int i=0; i<theInventory.getProductInformation().size(); i++){
			tmodel.addRow(theInventory.getProductInformation().get(i).print());
		}
		table.setModel(tmodel);
		return table;
	}

}

