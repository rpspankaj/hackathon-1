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

import com.walmart.hackathon.model.UserGroup;
import com.walmart.hackathon.model.GroupUserMapping;
import com.walmart.hackathon.persistence.GroupDao;
import com.walmart.hackathon.persistence.GroupUserMappingDao;

@Path("groups")
public class GroupResource {
	
	GroupDao groupDao;
	GroupUserMappingDao guMappingDao;
	
	@Inject
	public GroupResource(GroupDao groupDao,GroupUserMappingDao guMappingDao) {
		this.groupDao=groupDao;
		this.guMappingDao=guMappingDao;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<UserGroup> getGroups(){
		List<UserGroup> groups= groupDao.findAll();
		return groups;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserGroup save(@Valid UserGroup group) {
		UserGroup gp= groupDao.save(group);
		GroupUserMapping gum =new GroupUserMapping();
		gum.setGroupId(gp.getGroupId());
		gum.setUserId(gp.getCreatedBy());
		guMappingDao.save(gum);
		return gp;
        
    }
	
}
