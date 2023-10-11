package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learnSphere.Entity.Courses;
import com.learnSphere.Entity.Lesson;
import com.learnSphere.repositery.CourseRepositery;
import com.learnSphere.repositery.LessonRepositery;
@Service
public class TrainerServiceimplementation implements TrainerService{
	@Autowired
    CourseRepositery crepo;
	@Autowired
	LessonRepositery lrepo;
	public TrainerServiceimplementation(CourseRepositery crepo,LessonRepositery lrepo) {
	super();
	this.crepo = crepo;
	this.lrepo=lrepo;
}
	@Override
	public String addCourse(Courses courses) {
	crepo.save(courses);
		return "course add sucessfully";
	}
	@Override
	public String addLesson(Lesson lesson) {
		lrepo.save(lesson);
		return "lesson added sucessfully";
	}
	@Override
	public Courses getCourse(int courseId) {
		
		return crepo.findById(courseId).get();
	}
	@Override
	public List<Courses> courseList() {
		
		return crepo.findAll();
	}

}
