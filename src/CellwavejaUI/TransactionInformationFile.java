package CellwavejaUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import Core.Transaction;

public class TransactionInformationFile {
	ArrayList<Transaction> theTransactionInformationList=new ArrayList<Transaction>();
	public ArrayList<Transaction> readTransactionfile() {
		try {
			theTransactionInformationList.clear();
			FileReader file= new FileReader("Files\\TransactionFiles");
			BufferedReader reader= new BufferedReader(file); 
			String  text="";
			String line= reader.readLine();
			while(line!=null) {
				String []attributes=line.split("//");
				theTransactionInformationList.add(new Core.Transaction(Integer.parseInt(attributes[0]), attributes[6],attributes[8], attributes[1],attributes[2],attributes[9],attributes[3],attributes[4],attributes[5],Float.parseFloat(attributes[7]),Integer.parseInt(attributes[10])));
				text+= line;
				line=reader.readLine();
			}
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return theTransactionInformationList;
	}
	public boolean writeToTransactionFile(ArrayList<Transaction> trans) {
		File files=new File("Files");
		File transactionInfo= new File("Files\\TransactionFiles");
		if(files.exists()) {
			System.out.println("the folder already exists");

		}else {
			try {
				files.mkdirs();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if (transactionInfo.exists()) {
			System.out.println("the file already exists");
			try {
				FileWriter filew= new FileWriter(transactionInfo);
				BufferedWriter bufft=new BufferedWriter(filew);
	
				for(Core.Transaction t: trans) {
					bufft.write(t.getTransactionNumber()+"//"+t.getCustomerId()+"//"+ t.getCustomerName() +"//"+t.getProductName()+"//"+t.getProductType()+"//"+t.getProductColour()+"//"+t.getTransactionDate()+"//"+t.getCashtendered()+"//"+t.getCashOrCard()+"//"+t.getProductModelNumber()+"//"+t.getQuantitypurchased()+"\n" );
				}
				bufft.close();
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				transactionInfo.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				FileWriter filew= new FileWriter(transactionInfo);
				BufferedWriter bufft=new BufferedWriter(filew);
				for(Core.Transaction t:trans) {
					bufft.write(t.getTransactionNumber()+"//"+t.getCustomerId()+"//"+ t.getCustomerName() +"//"+t.getProductName()+"//"+t.getProductType()+"//"+t.getProductColour()+"//"+t.getTransactionDate()+"//"+t.getCashtendered()+"//"+t.getCashOrCard()+"//"+t.getProductModelNumber()+"//"+t.getQuantitypurchased()+"\n");
				}
				bufft.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
}
