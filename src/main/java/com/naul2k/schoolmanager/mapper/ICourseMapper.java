package com.naul2k.schoolmanager.mapper;

import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;
import com.naul2k.schoolmanager.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ICourseMapper {
//    @Mapping(source = "courseId", ignore = true) 
//    Course toEntity(CourseRequestDto dto);
//    CourseResponseDto toDto(Course entity);
//    CourseRequestDto toRequestDto(Course entity);
//    @Mapping(source = "courseId", ignore = true) 
//    Course toEntity(CourseResponseDto dto);
    
    ICourseMapper INSTANCE = Mappers.getMapper(ICourseMapper.class);
    CourseRequestDto courseToCourseRequestDto(Course course);
    Course courseRequestDtoToCourse(CourseRequestDto courseRequestDto);

    CourseResponseDto courseToCourseResponseDto(Course course);
    Course courseResponseDtoToCourse(CourseResponseDto courseResponseDto);
}
