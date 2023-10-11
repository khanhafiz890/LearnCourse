package com.learnSphere.services;

import com.learnSphere.Entity.User;

public interface UserService {
	//add user information to database
	String addUser(User u);
	// check  if the email present in the database
  boolean checkEmail(String email);
  //checking the password provided by user
  boolean valid(String email,String pass);
  //get the user roll by email
  String getUserRoll(String email);
}
