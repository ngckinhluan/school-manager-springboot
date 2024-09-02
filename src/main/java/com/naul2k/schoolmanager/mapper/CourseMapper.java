package com.naul2k.schoolmanager.mapper;

import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;
import com.naul2k.schoolmanager.entities.Course;

public interface CourseMapper {

    public static CourseResponseDto toCourseResponseDto(Course course) {
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setCourseId(course.getCourseId());
        courseResponseDto.setCourseName(course.getCourseName());
        courseResponseDto.setCourseDescription(course.getCourseDescription());
        return courseResponseDto;
    }

    public static Course toCourse(CourseResponseDto courseResponseDto) {
        Course course = new Course();
        course.setCourseId(courseResponseDto.getCourseId());
        course.setCourseName(courseResponseDto.getCourseName());
        course.setCourseDescription(courseResponseDto.getCourseDescription());
        return course;
    }

    public static Course toCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setCourseName(courseRequestDto.getCourseName());
        course.setCourseDescription(courseRequestDto.getCourseDescription());
        return course;
    }

    public static CourseRequestDto toCourseRequestDto(Course course) {
        CourseRequestDto courseRequestDto = new CourseRequestDto();
        courseRequestDto.setCourseName(course.getCourseName());
        courseRequestDto.setCourseDescription(course.getCourseDescription());
        return courseRequestDto;
    }
}
