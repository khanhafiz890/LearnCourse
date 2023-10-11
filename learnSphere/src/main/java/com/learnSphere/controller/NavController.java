package com.learnSphere.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.Entity.Comments;
import com.learnSphere.Entity.User;
import com.learnSphere.services.CommentService;
import com.learnSphere.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class NavController {
	@Autowired
	UserService us;
	@Autowired
	CommentService cService;
	 
	  public NavController(UserService us, CommentService cService) {
		super();
		this.us = us;
		this.cService = cService;
	}
	@PostMapping("/addUser")
		public String addStudent(@RequestParam("fname") String fname,
				@RequestParam("lname")String lname,@RequestParam("Email") String Email,
				@RequestParam("pass") String pass,@RequestParam("role") String role,
				@RequestParam("mobile") String mobile,HttpSession session) {
		  boolean existsEmail= us.checkEmail(Email);
		  if(existsEmail==false) {
			User u= new User();
			u.setFirst_name(fname);
			u.setLast_name(lname);
			u.setEmail(Email);
			u.setPassword(pass);
			u.setRole(role);
			u.setMobile(mobile);
			us.addUser(u);
			session.setAttribute("msg", "Register sucessfully");
			return  "redirect:/register";
		  }
		  else {
			  session.setAttribute("msg", "Email Already Exists!! pLease try again With new email Id");
			  return "redirect:/register";
		  }
			
		}
	  @PostMapping("/validate")
		public String addStudent(@RequestParam("Email") String Email,
				@RequestParam("pass") String pass) {
		  boolean existsEmail= us.checkEmail(Email);
		  if(existsEmail==true) {
			boolean v=us.valid(Email,pass);
			if(v==true) {
				// is valid user
				if(us.getUserRoll(Email).equals("Trainer")) {
				return"trainerHome";
			}
				else {
				return"studentHome";
			}
		  }
			//Wrong password
			else {
				//System.out.println("wrong  password please enter again");
				return "redirect:/register";
			}
		  }
		  else {
			  // email does not exist
			  System.out.println("email does not exist");
			  return "redirect:/login";
		  }
			
		}
@GetMapping("/")
  public String index() {
	  return "index";
  }
  @GetMapping("/login")
  public String login() {
	  return "login";
  }
  @GetMapping("/register")
  public String register() {
	  return "register";
  }
  @GetMapping("/addLesson")
  public String lesson() {
	  return "addLesson";
  }
  @GetMapping("/createCourse")
  public String createCourse() {
	  return "createCourse";
  }
  @GetMapping("/studentHome")
  public String studentHome() {
	  return "studentHome";
  }
  @GetMapping("/trainerHome")
  public String trainerHome() {
	  return "trainerHome";
  }
  @GetMapping("/courses")
  public String courses() {
	  return "courses";
  }

  @GetMapping("/myCourses")
  public String myCourses() {
	  return "myCourses";
  }
  @GetMapping("/purchase")
  public String purchase() {
	  return "purchase";
  }
  @GetMapping("/demoLesson")
  public String demoLesson() {
	  return "demoLesson";
  }
  @GetMapping("/home")
  public String home() {
	  return "home";
  }
  @PostMapping("/addComment")
  public String addComment(@RequestParam("comment") String comment) {
	   Comments c= new Comments();
	   c.setComment(comment);
	   cService.addComment(c);
	   return "index";
  }
  
}
