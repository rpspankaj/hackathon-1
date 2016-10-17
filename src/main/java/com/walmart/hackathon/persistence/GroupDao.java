package com.walmart.hackathon.persistence;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.walmart.hackathon.model.UserGroup;

public interface GroupDao extends JpaRepository<UserGroup,BigInteger>{
	
	@Query("select g from UserGroup g where groupId in( select u.groupId from GroupUserMapping u where u.userId=?1 )")
	public List<UserGroup> findGroupsOfUser(BigInteger userId);
}
