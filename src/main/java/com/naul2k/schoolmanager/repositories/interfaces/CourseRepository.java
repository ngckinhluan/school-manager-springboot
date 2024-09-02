package com.naul2k.schoolmanager.repositories.interfaces;
import com.naul2k.schoolmanager.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findCourseByCourseName(String courseName);
}
