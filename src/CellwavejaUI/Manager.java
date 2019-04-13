package CellwavejaUI;

import javax.swing.JOptionPane;

public class Manager implements Observer {
	private static Manager theManager=null;
	private String password="h";
	private String user="h";
	
	private Manager() {}
	
	public static Manager getInstance() {
		if(theManager==null) {
			theManager=new Manager();
		}
		return theManager;
		
	}
	public boolean login(String managerUsername, String managerPassword) {
		if (managerPassword.equals(this.password) && managerUsername.equals(this.user)) {
				return true;
			
		}
		return false;
	}
	@Override
	public void update(int n) {
		// TODO Auto-generated method stub
		switch(n) {
			case 1:
				JOptionPane.showMessageDialog(null, "Product Information Saved", "Notification", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2 :
				JOptionPane.showMessageDialog(null, "Transaction Information Saved", "Notification", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Customer Information Saved", "Notification", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "INPUT QUANTITY AS A NUMBER E.g 14 or 214", "Input Error", JOptionPane.INFORMATION_MESSAGE);
			case 5:
				JOptionPane.showMessageDialog(null, "INPUT Cost Price AS A NUMBER E.g 14.00 or 214.00", "Input Error", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "INPUT Selling price AS A NUMBER E.g 14.00 or 214.00", "Input Error", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 7:
				JOptionPane.showMessageDialog(null, "INPUT DATA IN ALL FIELDS", "Input Error", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "THIS PRODUCT IS ALREADY IN THE INVENTORY", "Input Error", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Product is either not in the inventory or Product details were inputted incorrectly", "Input Error", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 10:
				JOptionPane.showMessageDialog(null, "The Quantity of this product in the inventoy is zero and cannot be sold. Please update quantity in the inventory to make a sale", "Quantity Error", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 11:
				JOptionPane.showMessageDialog(null, "THIS CUSTOMER HAS ALREADY BEEN SAVED", "Input Error", JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}
}
