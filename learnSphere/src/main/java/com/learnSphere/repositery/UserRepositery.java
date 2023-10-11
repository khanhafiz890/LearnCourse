package com.learnSphere.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.Entity.User;

public interface UserRepositery extends JpaRepository<User, Long> {
	boolean existsByEmail(String  Email);
	User getByEmail(String Email);
}
