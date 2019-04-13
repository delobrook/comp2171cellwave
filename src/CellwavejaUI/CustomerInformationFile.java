package CellwavejaUI;

import java.io.*;
import java.util.*;

import Core.Customer;
import Core.Transaction;
public class CustomerInformationFile {
	ArrayList<Customer> theCustomerInformationList= new ArrayList<Customer>();
	public boolean writetoCustomerInformationFile(ArrayList<Customer> cus) {
		File files=new File("Files");
		File customerInfo= new File("Files\\CustomersFiles");
		if(files.exists()) {
			System.out.println("the folder already exists");
			
		}else {
			try {
				files.mkdirs();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if (customerInfo.exists()) {
			System.out.println("the files already exists");
			try {
				FileWriter filew= new FileWriter(customerInfo);
				BufferedWriter buffw=new BufferedWriter(filew);
	
				for(Core.Customer c: cus) {
					buffw.write(c.getCustomerid()+"//"+c.getName()+"//"+ c.getEmail() +"//"+c.getTelephone()+"//"+c.getAddresses()+"\n" );
				}
				buffw.close();
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
					customerInfo.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				FileWriter filew= new FileWriter(customerInfo);
				BufferedWriter buffw=new BufferedWriter(filew);
				for(Core.Customer c: cus) {
					buffw.write(c.getCustomerid()+"//"+c.getName()+"//"+ c.getEmail() +"//"+c.getTelephone()+"//"+c.getAddresses()+"\n");
				}
				buffw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}	
	public ArrayList<Customer> readCustomerfile() {
		try {
			theCustomerInformationList.clear();
			FileReader file= new FileReader("Files\\CustomersFiles");
			BufferedReader reader= new BufferedReader(file); 
			String  text="";
			String line= reader.readLine();
			while(line!=null) {
				String []attributes=line.split("//");
				theCustomerInformationList.add(new Core.Customer(attributes[0], attributes[1],attributes[2], attributes[3],(attributes[4])));
				text+= line;
				line=reader.readLine();
			
			}
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return theCustomerInformationList;
	}
	
}
