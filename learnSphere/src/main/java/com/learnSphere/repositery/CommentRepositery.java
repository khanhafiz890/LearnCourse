package com.learnSphere.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.Entity.Comments;


public interface CommentRepositery extends JpaRepository<Comments, Integer> {

}
