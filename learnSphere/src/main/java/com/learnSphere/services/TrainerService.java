package com.learnSphere.services;

import java.util.List;

import com.learnSphere.Entity.Courses;
import com.learnSphere.Entity.Lesson;

public interface TrainerService {
 public String addCourse(Courses course);
  public String addLesson(Lesson lesson);
  public Courses getCourse(int courseId);
  public List<Courses> courseList();
}
