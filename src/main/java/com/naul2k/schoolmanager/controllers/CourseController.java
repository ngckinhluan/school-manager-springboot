package com.naul2k.schoolmanager.controllers;

import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;
import com.naul2k.schoolmanager.mapper.ICourseMapper;
import com.naul2k.schoolmanager.services.interfaces.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final ICourseService _courseService;

    public CourseController(ICourseService courseService) {
        _courseService = courseService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<Void>> createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        return _courseService.createCourse(courseRequestDto)
                .thenApply(result -> ResponseEntity.status(HttpStatus.CREATED).build());
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<CourseResponseDto>> getCourseById(@PathVariable("id") Integer courseId) {
        return _courseService.getCourseById(courseId)
                .thenApply(courseDto -> {
                    if (courseDto != null) {
                        return ResponseEntity.ok(courseDto);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> updateCourse(@PathVariable("id") Integer courseId,
                                                                @RequestBody CourseRequestDto courseRequestDto) {
        return _courseService.updateCourse(courseId, courseRequestDto)
                .thenApply(result -> ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteCourse(@PathVariable("id") Integer courseId) {
        return _courseService.deleteCourse(courseId)
                .thenApply(result -> ResponseEntity.noContent().build());
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<CourseResponseDto>>> getAllCourses() {
        return _courseService.getAllCourses()
                .thenApply(courseDtos -> ResponseEntity.ok(courseDtos));
    }
}
