package com.naul2k.schoolmanager.services.implementations;

import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;
import com.naul2k.schoolmanager.entities.Course;
import com.naul2k.schoolmanager.mapper.ICourseMapper;
import com.naul2k.schoolmanager.repositories.interfaces.ICourseRepository;
import com.naul2k.schoolmanager.services.interfaces.ICourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {

    private final ICourseRepository repository;
    private final ICourseMapper mapper;

    public CourseService(ICourseRepository repository, ICourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CompletableFuture<Void> createCourse(CourseRequestDto courseRequestDto) {
        return CompletableFuture.runAsync(() -> {
            Course course = mapper.toEntity(courseRequestDto);
            repository.save(course);
        });
    }

    @Override
    public CompletableFuture<CourseResponseDto> getCourseById(Integer courseId) {
        return CompletableFuture.supplyAsync(() -> {
            Course course = repository.findById(courseId).orElse(null);
            return course != null ? mapper.toDto(course) : null;
        });
    }

    @Override
    public CompletableFuture<Void> updateCourse(Integer courseId, CourseRequestDto courseRequestDto) {
        return CompletableFuture.runAsync(() -> {
            Course course = mapper.toEntity(courseRequestDto);
            course.setCourseId(courseId);
            repository.save(course);
        });
    }

    @Override
    public CompletableFuture<Void> deleteCourse(Integer courseId) {
        return CompletableFuture.runAsync(() -> {
            repository.deleteById(courseId);
        });
    }

    @Override
    public CompletableFuture<List<CourseResponseDto>> getAllCourses() {
        return CompletableFuture.supplyAsync(() -> {
            List<Course> courses = repository.findAll();
            return courses.stream()
                    .map(mapper::toDto)
                    .collect(Collectors.toList());
        });
    }
}