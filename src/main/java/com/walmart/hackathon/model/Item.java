package com.walmart.hackathon.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonProperty
	@Transient
	List<Ingredient> ingredients;
	
	
	/*@NotNull
	@Column(name="ingredient_Id")
	BigInteger ingredientId;
	
	public BigInteger getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(BigInteger ingredientId) {
		this.ingredientId = ingredientId;
	}*/
	
	/*@NotNull
	@Column(name="ingredients")*/
	
	public BigInteger getItemId(){
		return itemId;
	}
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	
	
}
