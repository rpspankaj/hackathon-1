package com.walmart.hackathon.resources;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.walmart.hackathon.model.User;
import com.walmart.hackathon.persistence.UserDao;

@Path("/users")
public class UserResource {
	
	
	UserDao userDao;
	
	@Inject
	public UserResource(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		List<User> users =userDao.findAll();
		return users;
	}
	
	 /**
     * Create new USER
     * @param user
     * @return new user
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public User save(@Valid User user) {
        return userDao.save(user);
    }
}
