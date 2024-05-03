package com.example.assignment1.services.imp;
import com.example.assignment1.exceptions.ResourceNotFoundException;
import com.example.assignment1.model.Courses;
import com.example.assignment1.repo.RepoCourses;
import com.example.assignment1.request.RequestCourses;
import com.example.assignment1.services.CourseServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class ServiceImp implements CourseServices {
    @Autowired
    private RepoCourses repoCourses;

    @Override
    public Courses addCourse(RequestCourses requestCourses) {
        Courses coursez = null;
        try {
            if (requestCourses != null) {
                Courses existingCourse = repoCourses.findByCourseName(requestCourses.getCourseName());
                if (existingCourse != null) {
                    existingCourse.setDepartment(requestCourses.getDepartment());
                    existingCourse.setCourses(requestCourses.getCourseName());
                    existingCourse.setCourseCode(requestCourses.getCourseCode());

                    log.info("Updating information for course: " + existingCourse.getCourseCode());
                    coursez = repoCourses.save(existingCourse);
                } else {
                    log.error("Course not found with name: " + requestCourses.getCourseName());
                }
            } else {
                log.error("Invalid requestCourses object: null");
            }
        } catch (Exception e) {
            log.error("Error while saving or updating course: " + e.getMessage());
            e.printStackTrace();
        }
        return coursez;
    }


    @Override
    public Courses updateCourse(RequestCourses requestCourses, long id) {
        Courses coursez = null;
        try{
            Courses course = repoCourses.findById(id).get();
            course.setCourses(requestCourses.getCourseName());
            course.setCourseCode(requestCourses.getCourseCode());
            log.info("Updating information for course: " + coursez.getCourseCode());
            coursez= repoCourses.save(coursez);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error while updating course: " + coursez.getCourseCode());
        }
        return null;
    }

    @Override
    public Courses deleteCourse(long id) {
        try {
            Optional<Courses> optionalCourses = repoCourses.findById(id);
            if (optionalCourses.isPresent()) {
                Courses courseDelete = optionalCourses.get();
                repoCourses.deleteById(id);
            } else {
                System.out.println("Course with id " + id + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Courses getCourse(long id) {
        Optional<Courses> optionalCourses = repoCourses.findById(id);

        if (optionalCourses.isPresent()) {
            return optionalCourses.get();
        } else {
            throw new ResourceNotFoundException("Course not found with ID: " + id);
        }
    }

    @Override
    public List<Courses> getAllCourses() {
        return (List<Courses>) repoCourses;
    }
}
