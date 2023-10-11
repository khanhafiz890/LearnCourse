package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.Entity.Comments;
import com.learnSphere.repositery.CommentRepositery;
@Service
public class CommentServiceImolementation implements CommentService{
	@Autowired
   CommentRepositery crepo;
	public CommentServiceImolementation(CommentRepositery crepo) {
		super();
		this.crepo = crepo;
	}
	@Override
	public List<Comments> getComment() {
		List<Comments> clist=crepo.findAll();
		return clist;
	}
	@Override
	public String addComment(Comments comment) {
		crepo.save(comment);
		return "comment added sucessfully";
	}
	
}
