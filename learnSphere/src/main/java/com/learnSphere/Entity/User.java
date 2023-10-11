package com.learnSphere.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long Id;
	String First_name;
	String Last_name;
	@Column(name="Email")
	String email;
	String Password;
	String Role;
	String Mobile;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(Long id, String first_name, String last_name, String Email, String password, String role, String mobile) {
	super();
	Id = id;
	First_name = first_name;
	Last_name = last_name;
	email = Email;
	Password = password;
	Role = role;
	Mobile = mobile;
}
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public String getFirst_name() {
	return First_name;
}
public void setFirst_name(String first_name) {
	First_name = first_name;
}
public String getLast_name() {
	return Last_name;
}
public void setLast_name(String last_name) {
	Last_name = last_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String Email) {
	email = Email;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public String getMobile() {
	return Mobile;
}
public void setMobile(String mobile) {
	Mobile = mobile;
}
@Override
public String toString() {
	return "Users [Id=" + Id + ", First_name=" + First_name + ", Last_name=" + Last_name + ", Email=" + email
			+ ", Password=" + Password + ", Role=" + Role + ", Mobile=" + Mobile + "]";
}


}
