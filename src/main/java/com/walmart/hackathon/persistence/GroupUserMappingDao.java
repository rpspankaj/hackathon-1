package com.walmart.hackathon.persistence;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.walmart.hackathon.model.GroupUserMapping;

public interface GroupUserMappingDao extends JpaRepository<GroupUserMapping,BigInteger>{
	@Query("select gu from GroupUserMapping gu where gu.groupId = ?1")
	public List<GroupUserMapping> getGroup(BigInteger groupId);   

}
