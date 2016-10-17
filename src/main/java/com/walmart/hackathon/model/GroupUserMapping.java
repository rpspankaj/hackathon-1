package com.walmart.hackathon.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class GroupUserMapping {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger guMappingId;
	
	@NotNull
	@Column(name = "group_id")
	BigInteger groupId;
	
	@NotNull
	@Column(name = "user_id")
	BigInteger userId;
	
	@JsonProperty
	@Transient
	HackUser hackUser;
	
	public HackUser getHackUser() {
		return hackUser;
	}

	public void setHackUser(HackUser hackUser) {
		this.hackUser = hackUser;
	}

	public BigInteger getGuMappingId() {
		return guMappingId;
	}

	public void setGuMappingId(BigInteger guMappingId) {
		this.guMappingId = guMappingId;
	}

	public BigInteger getGroupId() {
		return groupId;
	}

	public void setGroupId(BigInteger groupId) {
		this.groupId = groupId;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	
	
}
