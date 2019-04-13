package Core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Product {
	private String colour;
	private String description;
	private String productName;
	private String productType;
	private Float costPrice;
	private Float sellingPrice;
	private int quantity;
	private String modelNumber;
	private String imageName;


	public Product(){}	

	public Product(String modelNumber, String productName, String productType, String description,
					Float costPrice, Float sellingPrice, int quantity, String imageName, String colour) {

		this.modelNumber = modelNumber;
		this.productName = productName;
		this.productType = productType;
		this.description = description;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
		this.imageName = imageName;
		this.colour = colour;

	}

	public static Product createProduct(String modelNumber, String productName, String productType, String description,
										Float costPrice, Float sellingPrice, int quantity, String imageName, String colour){

		Product newProduct = new Product(modelNumber, productName, productType, description, costPrice, sellingPrice, quantity, imageName, colour);
		return newProduct;								
	}

	
	public void setQuantity(int q) {
		this.quantity=q;
	}


	public Float getCostPrice() {
		return costPrice;
	}

	public Float getSellingPrice() {
		return sellingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getProductName() {
		return productName;
	}
	

	public String getColour() {
		return colour;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public String getProductType() {
		return productType;
	}

	public String getDescription() {
		return description;
	}
	public String getImageName(){
		return imageName;
	}

	public String[] print(){
		String[] productString = new String[]{
			getModelNumber(),getProductName(),getProductType(),
			Integer.toString(getQuantity()),getColour(),this.getCostPrice().toString(),
			getSellingPrice().toString(), getDescription()
		};
		
		return productString;
	}
	
	}



	

