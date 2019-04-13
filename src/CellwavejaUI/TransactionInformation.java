package CellwavejaUI;

import java.util.ArrayList;

import Core.Customer;
import Core.Transaction;

public class TransactionInformation extends Subject {
	TransactionInformationFile theTransactionInformationFile=new  TransactionInformationFile();
	public  ArrayList<Transaction> newTransactions = theTransactionInformationFile.readTransactionfile();
	public  void addtransaction(Transaction t) {
		newTransactions.add(t);
	}
	public  void clearTransactionInformation() {
		newTransactions.clear();
	}
	public void deleteTransaction(int selrow) {
		newTransactions.remove(selrow);
	}
	public   ArrayList<Transaction> getTransactionInformation(){
		return newTransactions;
	}
	public void setTransactionInformation(ArrayList<Transaction> t) {
		newTransactions=t;
	}
	public TransactionInformationFile getTheTransactionInformationFile() {
		return theTransactionInformationFile;
	}
}
