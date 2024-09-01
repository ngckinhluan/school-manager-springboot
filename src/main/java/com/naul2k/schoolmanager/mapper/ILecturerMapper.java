package com.naul2k.schoolmanager.mapper;

import com.naul2k.schoolmanager.dto.request.LecturerRequestDto;
import com.naul2k.schoolmanager.dto.response.LecturerResponseDto;
import com.naul2k.schoolmanager.entities.Lecturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
public interface ILecturerMapper {
//    @Mapping(target = "lecturerId", ignore = true)
//    Lecturer toEntity(LecturerRequestDto dto);
//    LecturerResponseDto toDto(Lecturer entity);
//    LecturerRequestDto toRequestDto(Lecturer entity);
//    @Mapping(target = "lecturerId", ignore = true)
//    Lecturer toEntity(LecturerResponseDto dto);
    ILecturerMapper INSTANCE = Mappers.getMapper(ILecturerMapper.class);
    LecturerRequestDto lecturerToLecturerRequestDto(Lecturer lecturer);
    Lecturer lecturerRequestDtoToLecturer(LecturerRequestDto lecturerRequestDto);
    LecturerResponseDto lecturerToLecturerResponseDto(Lecturer lecturer);
    Lecturer lecturerResponseDtoToLecturer(LecturerResponseDto lecturerResponseDto);
}
