package CellwavejaUI;

import java.util.ArrayList;

import Core.Product;

public class Inventory extends Subject {
	public InventoryFile TheInventoryFile=new InventoryFile();
	public ArrayList <Product> theInventory = TheInventoryFile.readProductfile();
	public  void addNewProduct(Product p) {
		theInventory.add(p);
	}
	public  void clearProductInformation() {
		theInventory.clear();
	}
	public  void deleteProduct(int selrow) {
		theInventory.remove(selrow);
	}
	public ArrayList<Product> getProductInformation(){
		return theInventory;
	}
	public void setProductInformation(ArrayList<Product> p) {
		theInventory=p;
	}
	public InventoryFile getInventoryFile() {
		return this.TheInventoryFile;
	}
}
