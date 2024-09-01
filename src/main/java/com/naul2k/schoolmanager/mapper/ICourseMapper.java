package com.naul2k.schoolmanager.mapper;

import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;
import com.naul2k.schoolmanager.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICourseMapper {
    @Mapping(target = "courseId", ignore = true) 
    Course toEntity(CourseRequestDto dto);
    CourseResponseDto toDto(Course entity);
    CourseRequestDto toRequestDto(Course entity);
    @Mapping(target = "courseId", ignore = true) 
    Course toEntity(CourseResponseDto dto);
}
