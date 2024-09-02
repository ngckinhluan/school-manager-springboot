package com.naul2k.schoolmanager.services.implementations;

import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;
import com.naul2k.schoolmanager.entities.Course;
import com.naul2k.schoolmanager.exception.ResourceNotFoundException;
import com.naul2k.schoolmanager.mapper.CourseMapper;
import com.naul2k.schoolmanager.repositories.interfaces.CourseRepository;
import com.naul2k.schoolmanager.services.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map((CourseMapper::toCourseResponseDto))
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDto getCourseById(Integer courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Course not found with given Id: " + courseId));
        return CourseMapper.toCourseResponseDto(course);
    }

    @Override
    public void addCourse(CourseRequestDto courseRequestDto) {
        Course course = CourseMapper.toCourse(courseRequestDto);
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Integer courseId, CourseRequestDto courseRequestDto) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with given Id: " + courseId));
        course.setCourseName(courseRequestDto.getCourseName());
        course.setCourseDescription(courseRequestDto.getCourseDescription());
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Course not found with given Id: " + courseId));
        courseRepository.delete(course);
    }
}
