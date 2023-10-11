package com.learnSphere.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.Entity.Lesson;

public interface LessonRepositery extends JpaRepository<Lesson, Integer> {

}
