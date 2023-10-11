package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.Entity.Lesson;
import com.learnSphere.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService sService;
	public StudentController(StudentService sService) {
		super();
		this.sService = sService;
	}
	@PostMapping("/goToLesson")
	public String myLesson(@RequestParam("lessonId") int lessonId,Model model) {
		//System.out.println(lessonId);
		Lesson lesson = sService.getLesson(lessonId);
		model.addAttribute("lesson", lesson);
		System.out.println(lesson);
		return "myLesson";
	}

}
