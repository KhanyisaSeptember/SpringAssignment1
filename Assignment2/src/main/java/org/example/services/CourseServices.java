package org.example.services;

import org.example.model.Courses;
import org.example.request.RequestCourses;

import java.util.List;

public interface CourseServices {

    Courses addCourse(RequestCourses requestCourses);
    Courses updateCourse(RequestCourses requestCourses, long id);
    Courses deleteCourse(long id);
    Courses getCourse(long id);
    List<Courses> getAllCourses();
}
