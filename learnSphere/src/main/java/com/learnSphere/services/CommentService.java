package com.learnSphere.services;

import java.util.List;

import com.learnSphere.Entity.Comments;

public interface CommentService {
 List<Comments> getComment();
 String addComment(Comments comment);
}
