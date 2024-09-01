package com.naul2k.schoolmanager.services.implementations;
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

    private final ICourseRepository _repository;
    private final ICourseMapper _mapper;

    public CourseService(ICourseRepository repository, ICourseMapper mapper) {
        _repository = repository;
        _mapper = mapper;
    }

    @Override
    public CompletableFuture<Void> createCourse(CourseResponseDto courseResponseDto) {
        Course course = _mapper.toEntity(courseResponseDto);
        _repository.save(course);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<CourseResponseDto> getCourseById(Integer courseId) {
        return CompletableFuture.supplyAsync(() -> {
            Course course = _repository.findById(courseId).orElse(null);
            return _mapper.toDto(course);
        });
    }

    @Override
    public CompletableFuture<Void> updateCourse(Integer courseId, CourseResponseDto courseResponseDto) {
        return CompletableFuture.runAsync(() -> {
            Course course = _mapper.toEntity(courseResponseDto);
            course.setCourseId(courseId);
            _repository.save(course);
        });
    }

    @Override
    public CompletableFuture<Void> deleteCourse(Integer courseId) {
        return CompletableFuture.runAsync(() -> {
            _repository.deleteById(courseId);
        });
    }

    @Override
    public CompletableFuture<List<CourseResponseDto>> getAllCourses() {
        return CompletableFuture.supplyAsync(() -> {
            List<Course> courses = _repository.findAll();
            return courses.stream()
                    .map(_mapper::toDto)
                    .collect(Collectors.toList());
        });
    }
}
