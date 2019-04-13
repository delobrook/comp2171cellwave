package CellwavejaUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import Core.Product;

public class InventoryFile {
	ArrayList<Product> theInventoryList=new ArrayList<Product>();
	
	public ArrayList<Product> readProductfile() {
		
		try {
			theInventoryList.clear();
			FileReader file= new FileReader("Files\\ProductFiles");
			BufferedReader reader= new BufferedReader(file); 
			String  text="";
			String line= reader.readLine();
			while(line!=null) {
				String []attributes=line.split("//");
				theInventoryList.add(Product.createProduct(attributes[0], attributes[1],attributes[2], attributes[3],Float.valueOf((attributes[4])),Float.valueOf( attributes[5]),Integer.valueOf( attributes[6]), attributes[7], attributes[8]));
				text+= line;
				line=reader.readLine();
			}
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return theInventoryList;
	}
	
	public boolean writeToProductFile(ArrayList<Core.Product> products) {
		File files=new File("Files");
		File productInfo= new File("Files\\ProductFiles");
		if(files.exists()) {
			System.out.println("the folder already exists");
		}else {
			try {
				files.mkdirs();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if (productInfo.exists()) {
			System.out.println("the files already exists");
			try {
				FileWriter filew= new FileWriter(productInfo);
				BufferedWriter buffw=new BufferedWriter(filew);
				for(Core.Product p: products) {
					buffw.write(p.getModelNumber()+"//"+p.getProductName()+"//"+ p.getProductType() +"//"+p.getDescription()+"//"+p.getCostPrice()+"//"+p.getSellingPrice()+"//"+p.getQuantity()+"//"+p.getImageName()+"//"+p.getColour()+"\n" );
				}
				buffw.close();
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				productInfo.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				FileWriter filew= new FileWriter(productInfo);
				BufferedWriter buffw=new BufferedWriter(filew);
				for(Core.Product p: products) {
					buffw.write(p.getModelNumber()+"//"+p.getProductName()+"//"+ p.getProductType() +"//"+p.getDescription()+"//"+p.getCostPrice()+"//"+p.getSellingPrice()+"//"+p.getQuantity()+"//"+p.getImageName()+"//"+p.getColour()+"\n" );
				}
				buffw.write("hello ");
				buffw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}			
	
}
