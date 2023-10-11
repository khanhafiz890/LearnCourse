package com.learnSphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.Entity.Lesson;
import com.learnSphere.repositery.LessonRepositery;
@Service
public class StudentServiceImplementation implements StudentService{
	@Autowired
    LessonRepositery lrepo;
	public StudentServiceImplementation(LessonRepositery lrepo) {
		super();
		this.lrepo = lrepo;
	}
	@Override
	public Lesson getLesson(int lessonId) {
		
		return lrepo.findById(lessonId).get();
	}

}
