package com.walmart.hackathon.persistence;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.hackathon.model.User;

public interface UserDao extends JpaRepository<User,BigInteger>{

}
