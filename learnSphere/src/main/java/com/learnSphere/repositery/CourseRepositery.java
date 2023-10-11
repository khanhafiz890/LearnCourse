package com.learnSphere.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.Entity.Courses;


public interface CourseRepositery extends JpaRepository<Courses, Integer> {

}
