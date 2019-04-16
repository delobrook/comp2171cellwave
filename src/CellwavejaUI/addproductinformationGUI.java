package CellwavejaUI;
import Core.*;

import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import Core.Product;

// import java.util.*;
// import javax.swing.JPanel;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;

// import java.awt.Font;
// import java.awt.Graphics2D;
// import java.awt.Color;
// import java.awt.Dimension;

// import javax.swing.JTextField;
// import javax.swing.filechooser.FileNameExtensionFilter;
// import javax.swing.JSeparator;
// import javax.swing.JTextArea;
// import javax.swing.JButton;
// import javax.swing.JFileChooser;
// import javax.swing.ImageIcon;
// import java.awt.BorderLayout;
// import java.awt.FlowLayout;

// import javax.imageio.ImageIO;
// import javax.swing.Box;
// import javax.swing.BoxLayout;
// import java.awt.GridLayout;
// import java.awt.Image;
// import java.awt.event.ActionListener;
// import java.awt.image.BufferedImage;
// import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
// import java.awt.event.ActionEvent;
// import javax.swing.JScrollPane;

public class addproductinformationGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldModelNumber;
	private JTextField textField_1ProductName;
	private JTextField textField_2ProductType;
	private JTextField textField_3Quantity;
	private JTextField textField_4Colour;
	private JTextField textField_5CostPrice;
	private JTextField textField_6SellingPrice;

	private String colour;
	private String description;
	private String productName;
	private String productType;
	private Float costPrice;
	private Float sellingPrice;
	private int quantity;
	private String modelNumber;
	private String imageName;
	Inventory theInventory=new Inventory();
	

	private String productImageName;
	private String productImagePath=null;
	private RenderedImage rImage;
	private File saveFile;
	/**
	 * Create the panel.
	 */
	public addproductinformationGUI() {
		theInventory.attachObserver(Manager.getInstance());
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(568, 13, 493, 421);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("");
		scrollPane.setViewportView(lblNewLabel_2);
		
		JLabel lblEnterNewProducts = new JLabel("Add New Product Information ");
		lblEnterNewProducts.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEnterNewProducts.setBounds(97, 13, 677, 66);
		panel.add(lblEnterNewProducts);
		
		JLabel lblNewLabel = new JLabel("Model #:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(42, 92, 136, 16);
		panel.add(lblNewLabel);
		
		JLabel lblProductName = new JLabel("Product Name:\r\n");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductName.setBounds(42, 125, 130, 16);
		panel.add(lblProductName);
		
		JLabel lblNewLabel_1 = new JLabel("Product Type:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(42, 154, 130, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblColour = new JLabel("Colour:");
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblColour.setBounds(42, 215, 75, 27);
		panel.add(lblColour);
		
		JLabel lblSellingPrice = new JLabel("Selling Price:");
		lblSellingPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellingPrice.setBounds(41, 284, 107, 27);
		panel.add(lblSellingPrice);
		
		JLabel lblCostPrice = new JLabel("Cost Price:");
		lblCostPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCostPrice.setBounds(41, 255, 158, 21);
		panel.add(lblCostPrice);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantity.setBounds(42, 184, 130, 25);
		panel.add(lblQuantity);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescription.setBounds(41, 316, 130, 27);
		panel.add(lblDescription);
		
		textFieldModelNumber = new JTextField();
		textFieldModelNumber.setBounds(190, 86, 366, 22);
		panel.add(textFieldModelNumber);
		textFieldModelNumber.setColumns(10);
		
		textField_1ProductName = new JTextField();
		textField_1ProductName.setColumns(10);
		textField_1ProductName.setBounds(190, 119, 366, 22);
		panel.add(textField_1ProductName);
		productName = textField_1ProductName.getText();
		
		textField_2ProductType = new JTextField();
		textField_2ProductType.setColumns(10);
		textField_2ProductType.setBounds(190, 153, 366, 22);
		panel.add(textField_2ProductType);
		
		textField_3Quantity = new JTextField();
		textField_3Quantity.setToolTipText("Enter a number e.g 14 or 20\r\n");
		textField_3Quantity.setColumns(10);
		textField_3Quantity.setBounds(190, 185, 366, 22);
		panel.add(textField_3Quantity);
		
		textField_4Colour = new JTextField();
		textField_4Colour.setColumns(10);
		textField_4Colour.setBounds(190, 217, 366, 22);
		panel.add(textField_4Colour);
		
		textField_5CostPrice = new JTextField();
		textField_5CostPrice.setToolTipText("Enter value as a Number e.g 14.00 or 600.00");
		textField_5CostPrice.setColumns(10);
		textField_5CostPrice.setBounds(190, 252, 366, 22);
		panel.add(textField_5CostPrice);
		
		textField_6SellingPrice = new JTextField();
		textField_6SellingPrice.setToolTipText("Enter value as a Number e.g 14.00 or 600.00");
		textField_6SellingPrice.setColumns(10);
		textField_6SellingPrice.setBounds(190, 284, 366, 22);
		panel.add(textField_6SellingPrice);

		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setBounds(183, 323, 373, 111);
		panel.add(textAreaDescription);
		
		JButton btnNewButton = new JButton("Save Product",new ImageIcon(addproductinformationGUI.class.getResource("\\images\\saveicon.PNG")));
		btnNewButton.setBackground(Color.decode("#BEE5F9"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (testUserInput()==true) {
					modelNumber = textFieldModelNumber.getText();
					productName = textField_1ProductName.getText();
					productType = textField_2ProductType.getText();
					colour = textField_4Colour.getText();
					costPrice = Float.valueOf(textField_5CostPrice.getText());
					sellingPrice = Float.valueOf(textField_6SellingPrice.getText());
					quantity = Integer.parseInt(textField_3Quantity.getText());
					description = textAreaDescription.getText();
					imageName = productImageName;

					/*try {
						ImageIO.write(rImage,"png", saveFile);
					} catch (IOException ioe) {
						// Auto-generated catch block
						ioe.printStackTrace();
					}*/
					removeAll();
					theInventory.addNewProduct(Product.createProduct(modelNumber, productName, productType, description, costPrice, sellingPrice, quantity, productImagePath, colour));
					if(theInventory.getInventoryFile().writeToProductFile((theInventory.getProductInformation()))==true) {
						theInventory.notifyObserversofSuccessfuladdition(1);
					}
					add(new InventoryUI(),BorderLayout.CENTER);
					revalidate();
					
				}	
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(361, 463, 205, 101);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel\r\n",new ImageIcon(addproductinformationGUI.class.getResource("images\\cancelicon.PNG")));
		btnNewButton_1.setBackground(Color.decode("#BEE5F9"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(new InventoryUI(),BorderLayout.CENTER);
				revalidate();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(75, 463, 185, 100);
		panel.add(btnNewButton_1);
		
		JButton btnAddImage = new JButton("Add product Image");//,new ImageIcon(addproductinformationGUI.class.getResource("/images/add product.PNG")));
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser productImageLoc=new JFileChooser();
				productImageLoc.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter imageFilter=new FileNameExtensionFilter("*.Images","jpg","gif","png");
				productImageLoc.addChoosableFileFilter(imageFilter);
				int result=productImageLoc.showSaveDialog(null);
				if(result==productImageLoc.APPROVE_OPTION) {
					File selectedImage= productImageLoc.getSelectedFile();
					String imagePath=selectedImage.getAbsolutePath();
					productImagePath=selectedImage.getAbsolutePath();
					Image i= new ImageIcon(imagePath).getImage();
					Image newi=i.getScaledInstance(493,421 , Image.SCALE_SMOOTH);
					lblNewLabel_2.setIcon(new ImageIcon(newi));
					productImageName=selectedImage.getName();
					saveFile=new File(productImageName);
					BufferedImage bImage      = new BufferedImage(newi.getWidth(null), newi.getHeight(null), BufferedImage.TYPE_INT_RGB); 
					Graphics2D bImageGraphics = bImage.createGraphics();
					bImageGraphics.drawImage(newi, null, null);
					rImage  = (RenderedImage)bImage;
					
					
					
				}else if (result==productImageLoc.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null,"no Image selected","",JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				
			}
		});
		btnAddImage.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddImage.setBounds(725, 472, 210, 92);
		panel.add(btnAddImage);
		
		JLabel lbloptional = new JLabel("(OPTIONAL)");
		lbloptional.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbloptional.setBounds(769, 449, 108, 27);
		panel.add(lbloptional);
		
		
		
	}

	public boolean testUserInput() {
		boolean success=true;
		try{	
			if(textField_3Quantity.getText().isEmpty()) {
			}else {
				Integer.parseInt(textField_3Quantity.getText());	
			}	
		}catch(NumberFormatException nfe) {
			success=false;
			theInventory.notifyObserverOfErrorsInAddingProduct(4);
		}
		try{	
			if(textField_5CostPrice.getText().isEmpty()) {
			}else {
				Float.parseFloat(textField_5CostPrice.getText());	
			}
		}catch(NumberFormatException nfe) {
				success=false;
				theInventory.notifyObserverOfErrorsInAddingProduct(5);
		}	
		try{	
			if(textField_6SellingPrice.getText().isEmpty()) {
			}else {
				Float.parseFloat(textField_6SellingPrice.getText());
			}
		}catch(NumberFormatException nfe) {
				success=false;
				theInventory.notifyObserverOfErrorsInAddingProduct(6);
		}			
		if(textField_5CostPrice.getText().isEmpty()||textField_6SellingPrice.getText().isEmpty()||textFieldModelNumber.getText().isEmpty()||textField_1ProductName.getText().isEmpty()||textField_2ProductType.getText().isEmpty()||textField_3Quantity.getText().isEmpty()||textField_4Colour.getText().isEmpty()) {
			success=false;
			theInventory.notifyObserverOfErrorsInAddingProduct(7);
		}	
		for (int i=0; i<theInventory.getProductInformation().size(); i++){
			if(textField_1ProductName.getText().equals(theInventory.getProductInformation().get(i).getProductName())&&textFieldModelNumber.getText().equals(theInventory.getProductInformation().get(i).getModelNumber())&&textField_2ProductType.getText().equals(theInventory.getProductInformation().get(i).getProductType())&&textField_4Colour.getText().equals(theInventory.getProductInformation().get(i).getColour())) {
				success=false;
				theInventory.notifyObserverOfErrorsInAddingProduct(8);
				break;
			}
		}
	
		return success;
	}
	
}