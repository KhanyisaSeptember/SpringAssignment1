package org.example.repo;

import org.example.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCourses extends JpaRepository<Courses, Long> {
    Courses findByCourseName(String courseName);
}
