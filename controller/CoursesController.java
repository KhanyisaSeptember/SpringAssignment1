package com.example.assignment1.controller;
import com.example.assignment1.model.Courses;
import com.example.assignment1.repo.RepoCourses;
import com.example.assignment1.request.RequestCourses;
import com.example.assignment1.services.CourseServices;
import jdk.jfr.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CoursesController {
    @Autowired
    private CourseServices courseServices;
    @Autowired
    private RepoCourses repoCourses;

    @PostMapping("/save")
    ResponseEntity<Courses> save(@RequestBody RequestCourses requestCourse){
        return ResponseEntity.ok(courseServices.addCourse(requestCourse));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Courses>> get(){
        return ResponseEntity.ok(courseServices.getAllCourses());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Courses> updateTittle(@PathVariable("id") long id, @RequestBody RequestCourses requestCourses) {
        Courses update = courseServices.updateCourse(requestCourses, id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Courses> deleteTittle(@PathVariable("id") long id) {
        Courses delete = courseServices.deleteCourse(id);
        return ResponseEntity.ok(delete);
    }
    @GetMapping(value="/getCourse/{id}")
    public ResponseEntity<Optional<Courses>> getCourse(@PathVariable long id) {
        Optional<Courses> get = repoCourses.findById(id);
        return ResponseEntity.ok(get);
    }
}
