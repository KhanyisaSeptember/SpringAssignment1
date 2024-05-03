package com.example.assignment1.services;
import com.example.assignment1.model.Courses;
import com.example.assignment1.request.RequestCourses;

import java.util.List;
public interface CourseServices {
    Courses addCourse(RequestCourses requestCourses);
    Courses updateCourse(RequestCourses requestCourses, long id);
    Courses deleteCourse(long id);
    Courses getCourse(long id);
    List<Courses> getAllCourses();
}
