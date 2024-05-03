package com.example.assignment1.repo;

import com.example.assignment1.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCourses extends JpaRepository<Courses, Long> {
    Courses findByCourseName(String courseName);
}