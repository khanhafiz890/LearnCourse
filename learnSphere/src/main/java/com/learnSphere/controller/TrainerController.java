package com.learnSphere.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.learnSphere.Entity.Courses;
import com.learnSphere.Entity.Lesson;
import com.learnSphere.services.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	TrainerService tService;
 public TrainerController(TrainerService tService) {
		super();
		this.tService = tService;
	}
 //add course information to the database
		@PostMapping("/addCourse")
		 public  String addCourse(@RequestParam("courseId") int courseId,
					@RequestParam("courseName")String courseName,
					@RequestParam("coursePrice") int coursePrice) {
		
		  Courses courses=new Courses();
		  courses.setCourseId(courseId);
		  courses.setCourseName(courseName);
		  courses.setCoursePrice(coursePrice);
		  tService.addCourse(courses);
			 
			 return "redirect:/";
		 }
		@PostMapping("/addLesson")
		 public  String addLesson(@RequestParam("courseId") int courseId,
					@RequestParam("lessonId")int lessonId,
					@RequestParam("lessonName") String lessonName,
					@RequestParam("topics") String topics,
					@RequestParam("link") String link) {
		
		  //System.out.println(courseId+" "+lessonId+lessonName+topics+link);
			Courses course= tService.getCourse(courseId);
			Lesson lesson= new Lesson(lessonId,lessonName,topics,link,course);
			tService.addLesson(lesson);
			course.getLessons().add(lesson);
			
			 
			 return "redirect:/";
		 }
		@GetMapping("/showCourses")
		public String showCourses(Model model) {
			List<Courses> couresList= tService.courseList();
			model.addAttribute("couresList",couresList);
			//System.out.println(couresList);
			return "courses";
		}
}
