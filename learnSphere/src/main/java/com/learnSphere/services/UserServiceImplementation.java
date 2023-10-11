package com.learnSphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.Entity.User;
import com.learnSphere.repositery.UserRepositery;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
UserRepositery urepo;
	public UserServiceImplementation(UserRepositery urepo) {
	super();
	this.urepo = urepo;
}
	@Override
	public String addUser(User user) {
		urepo.save(user);
		return "Student added successfully";
	}
	@Override
	public boolean checkEmail(String Email) {
		
		return urepo.existsByEmail(Email);
	}
	@Override
	public boolean valid(String Email, String pass) {
		User user= urepo.getByEmail(Email);
		String dbpass=user.getPassword();
	
		return dbpass.equals(pass);
	}
	@Override
	public String getUserRoll(String email) {
		User user= urepo.getByEmail(email);
		return user.getRole();
	}
	

}
