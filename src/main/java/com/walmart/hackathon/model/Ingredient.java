package com.walmart.hackathon.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ingredient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger ingredientId;
	
	@NotNull
	@Column(name="Ingredient_name")
	String ingredientName;
	
	@NotNull
	@Column(name="Ingredient_quantity")
	String ingredientQuantity;

	@NotNull
	@Column(name="item_Id")
	BigInteger itemId;
	


	public BigInteger getItemId() {
		return itemId;
	}

	public void setItemId(BigInteger itemId) {
		this.itemId = itemId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getIngredientQuantity() {
		return ingredientQuantity;
	}

	public void setIngredientQuantity(String ingredientQuantity) {
		this.ingredientQuantity = ingredientQuantity;
	}
	
}