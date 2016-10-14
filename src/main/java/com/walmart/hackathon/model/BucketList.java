package com.walmart.hackathon.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class BucketList {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger bucketListID;
	
	@NotNull
	@Column(name = "item_id")
	BigInteger itemId;
	@NotNull
	@Column(name = "item_qty")
	Double itemQty;
	
	@NotNull
	@Column(name = "user_id")
	BigInteger userId;
	
	@NotNull
	@Column(name = "group_id")
	BigInteger userGroupId;

	public BigInteger getBucketListID() {
		return bucketListID;
	}

	public void setBucketListID(BigInteger bucketListID) {
		this.bucketListID = bucketListID;
	}

	public BigInteger getItemId() {
		return itemId;
	}

	public void setItemId(BigInteger itemId) {
		this.itemId = itemId;
	}

	public Double getItemQty() {
		return itemQty;
	}

	public void setItemQty(Double itemQty) {
		this.itemQty = itemQty;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public BigInteger getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(BigInteger userGroupId) {
		this.userGroupId = userGroupId;
	}
	
	
}
