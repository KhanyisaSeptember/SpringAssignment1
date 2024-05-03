package org.example.request;

import jdk.jfr.Event;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Courses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class RequestCourses {
    private String courseName;
    private String courseCode;
    private String department;


}
