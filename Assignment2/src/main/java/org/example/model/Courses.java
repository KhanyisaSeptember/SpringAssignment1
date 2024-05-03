package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="computer_science_courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private static final long serialVersionUID = 1L;

    private String courses;

    private String department;
    private String courseCode;

}
