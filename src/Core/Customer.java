package Core;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer {
    private  String customerid ;
    private  String telephone;
    private  String name ;
    private String email ;
    private  String addresses ;
    private  ArrayList<Transaction> transactions;
	

    public Customer(String clid, String name_, String address_,
                  String tel_, String email_){
        this.transactions = getTransactions();
        // Parish pa = Parish.KingstonStAndrew;  // default parish
       

        this.addresses=address_;
        this.telephone = tel_;
        this.name = name_;
       this.customerid = clid;
        this.email = email_;
    }

	

    public String[] print() {
    	String[] customerString= new String[]{ getCustomerid(),getName(),getEmail(),getTelephone(),getAddresses()};
    	return customerString;
    }
	

	public  String getTelephone() {
		return telephone;
	}

	public  String getEmail() {
		return email;
	}

	public  String getName() {
		return name;
	}

	public   String getAddresses() {
		return addresses;
	}

	public String getCustomerid() {
		return customerid;
	}
	

    private  ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getCustomer() {
        return toString();
    }
}
