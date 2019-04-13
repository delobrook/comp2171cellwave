package Core;

import java.util.Date;

import CellwavejaUI.AddnewTransactiontofile;
import CellwavejaUI.CustomerInformation;
import CellwavejaUI.Inventory;
import CellwavejaUI.TransactionInformation;

public class Transaction{

    private String transactionDate;
    private String customerId;
    private String customerName;
    private String productModelNumber;
    private String productName;
    private String productType;
    private String productColour;
    private Float cashTendered;
    private int transactionNumber;
    private String cashOrcard;
    private Product product=null;
    private Customer customer=null;
    private int quantityp;
    //private int productQuantity;
    //private ArrayList<Product> products = new ArrayList<Product>;
    
    public Transaction(int transactionNum, String transactionDate, String cashOrCard, String customerId, String customerName, String productModelNumber,
                        String productName, String productType, String productColour, Float cashTendered,int quantity){

        this.transactionDate = transactionDate;
        this.cashOrcard = cashOrCard;
        this.customerId = customerId;
        this.customerName = customerName;
        this.productModelNumber = productModelNumber;
        this.productName = productName;
        this.productType = productType;
        this.productColour = productColour;
        this.cashTendered = cashTendered;
        this.transactionNumber = transactionNum;
        this.quantityp=quantity;
        Inventory theInventory=new Inventory();
        CustomerInformation theCustomerInformation=new CustomerInformation();
		 for (int i=0; i<theCustomerInformation.getCustomerInformation().size(); i++){
	        	if (theCustomerInformation.getCustomerInformation().get(i).getCustomerid()==customerId&&theCustomerInformation.getCustomerInformation().get(i).getName()==customerName) {
	        		customer=theCustomerInformation.getCustomerInformation().get(i);
	        		break;
	        	}
	        }
        for (int i=0; i<theInventory.getProductInformation().size(); i++){
        	if (theInventory.getProductInformation().get(i).getModelNumber()==productModelNumber&&theInventory.getProductInformation().get(i).getColour()==productColour&&theInventory.getProductInformation().get(i).getProductName()==productName&&theInventory.getProductInformation().get(i).getProductType()==productType) {
        		product=theInventory.getProductInformation().get(i);
        		break;
        	}
        }

    }

    public int getTransactionNumber(){
        return transactionNumber;
    }
    public String getTransactionMonth() {
    	return this.transactionDate.substring(3,5);
    }
    public String getTransactionYear() {
    	return this.transactionDate.substring(7, 11);
    }
    public String getTMonthYear() {
    	return transactionDate.substring(3,4);
    }
    public String getTransactionDate(){
        return transactionDate;
    }

    public String getCashOrCard(){
        return cashOrcard;            
    }

    public String getCustomerId(){
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductModelNumber() {
        return productModelNumber;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductColour() {
        return productColour;
    }

    public Float getCashtendered(){
        return this.cashTendered;
    }
    public int getQuantitypurchased() {
    	return this.quantityp;
    }
    public String[] print(){
		String[] transactionString = new String[]{
            Integer.toString(getTransactionNumber()),getCustomerId(), getProductModelNumber(),
            getProductName(), getProductType(), getProductColour(),getTransactionDate().toString(),
            Float.toString(getCashtendered()), getCashOrCard(),Integer.toString(getQuantitypurchased())
        };
        return transactionString;
    }
  

	

}
