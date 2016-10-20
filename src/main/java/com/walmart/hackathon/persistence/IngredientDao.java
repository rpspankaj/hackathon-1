package com.walmart.hackathon.persistence;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.walmart.hackathon.model.Ingredient;

public interface IngredientDao extends JpaRepository<Ingredient,BigInteger>{
	
	@Query("select ing from Ingredient ing where ing.itemId =?1")
	public List<Ingredient>  getIngedientsByItem(BigInteger intemId );
}
