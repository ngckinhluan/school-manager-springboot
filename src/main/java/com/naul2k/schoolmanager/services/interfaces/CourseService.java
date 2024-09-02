package com.naul2k.schoolmanager.services.interfaces;

import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;

import java.util.List;

public interface CourseService {
    List<CourseResponseDto> getAllCourses();
    List<CourseResponseDto> getCourseByName(String courseName);
    CourseResponseDto getCourseById(Integer courseId);
    void addCourse(CourseRequestDto courseRequestDto);
    void updateCourse(Integer courseId, CourseRequestDto courseRequestDto);
    void deleteCourse(Integer courseId);
}
