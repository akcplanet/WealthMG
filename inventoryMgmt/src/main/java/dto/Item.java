package main.java.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable
	{
	       private String productName;
	       private int productCode;
	       private int quantity;
	       private BigDecimal price;

		public Item()
		{
		productName = "";
		productCode = 0;
		quantity = 0;
		price = new BigDecimal(0);
		}

		    //constructor
		public Item(String productName, int productCode, int quantity, BigDecimal price)
		{
		    this.productName = productName;
		    this.productCode = productCode;
		    this.quantity = quantity;
		    this.price = price;
		}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}





	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


}
