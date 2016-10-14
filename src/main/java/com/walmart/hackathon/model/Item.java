package com.walmart.hackathon.model;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Item {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger itemId;
	
	@NotNull
	@Column(name="item_name")
	String itemName;
	
	@NotNull
	@Column(name="gtin")
	String gtin;
	
	@NotNull
	@Column(name="price")
	Float price;
	
	@NotNull
	@Column(name="quantity")
	Integer quantity;
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigInteger getItemId() {
		return itemId;
	}

	public void setItemId(BigInteger itemId) {
		this.itemId = itemId;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}
	
}
