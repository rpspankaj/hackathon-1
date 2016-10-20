package com.walmart.hackathon.resources;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.walmart.hackathon.model.Ingredient;
import com.walmart.hackathon.persistence.IngredientDao;

@Path("/ingredients")
public class IngredientResource {
	
	IngredientDao ingredientsDao;
	
	@Inject
	public IngredientResource(IngredientDao ingredientsDao) {
		this.ingredientsDao=ingredientsDao;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Ingredient> getIngredients(){
		List<Ingredient> ingredients =ingredientsDao.findAll();
		return ingredients;
	}
	
	 /**
     * Create new ITEM
     * @param item
     * @return new item
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public Ingredient save(@Valid Ingredient ingredients) {
        return ingredientsDao.save(ingredients);
    }

}
