package com.naul2k.schoolmanager.controllers;

import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;
import com.naul2k.schoolmanager.services.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        List<CourseResponseDto> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable("id") Integer courseId) {
        CourseResponseDto course = courseService.getCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable Integer id, @RequestBody CourseRequestDto courseRequestDto) {
        courseService.updateCourse(id, courseRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Void> addCourse(@RequestBody CourseRequestDto courseRequestDto) {
        courseService.addCourse(courseRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
