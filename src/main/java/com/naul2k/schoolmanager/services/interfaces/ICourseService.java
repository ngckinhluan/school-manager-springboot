package com.naul2k.schoolmanager.services.interfaces;

import com.naul2k.schoolmanager.dto.response.CourseResponseDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ICourseService {
    // Equivalent to Task CreateCourse(CourseResponseDto courseResponseDto); in ASP.NET
    CompletableFuture<Void> createCourse(CourseResponseDto courseResponseDto);

    CompletableFuture<CourseResponseDto> getCourseById(Integer courseId);

    CompletableFuture<Void> updateCourse(Integer courseId, CourseResponseDto courseResponseDto);

    CompletableFuture<Void> deleteCourse(Integer courseId);
    
    CompletableFuture<List<CourseResponseDto>> getAllCourses();
}
