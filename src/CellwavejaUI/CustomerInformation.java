package CellwavejaUI;

import java.util.ArrayList;

import Core.Customer;


public class CustomerInformation extends Subject{
	public CustomerInformationFile theCustomerInformationFile=new  CustomerInformationFile();
	public ArrayList <Customer> customers = theCustomerInformationFile.readCustomerfile();
	public void addcustomer(Customer p) {
		customers.add(p);
	}
	public void clearCustomerInformation() {
		customers.clear();
	}
	public void deletecustomer(int selrow) {
		customers.remove(selrow);
	}
	public  ArrayList<Customer> getCustomerInformation(){
		return customers;
	}
	public void setCustomerInformation(ArrayList<Customer>c) {
		customers=c;
	}
	public CustomerInformationFile gettheCustomerInformationFile() {
		return theCustomerInformationFile;
	}
}
