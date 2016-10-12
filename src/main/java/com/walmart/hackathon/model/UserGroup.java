package com.walmart.hackathon.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserGroup {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger groupId;
	
	@NotNull
	@Column(name = "group_name")
	String groupName;
	
	@NotNull
	@Column(name = "created_by")
	BigInteger createdBy;

	public BigInteger getGroupId() {
		return groupId;
	}

	public void setGroupId(BigInteger groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
