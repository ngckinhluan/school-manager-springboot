package com.naul2k.schoolmanager.services.interfaces;

import com.naul2k.schoolmanager.dto.request.LecturerRequestDto;
import com.naul2k.schoolmanager.dto.response.LecturerResponseDto;
import com.naul2k.schoolmanager.entities.Lecturer;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ILecturerService {
    CompletableFuture<Void> createLecturer(LecturerRequestDto lecturerRequestDto);

    CompletableFuture<Void> updateLecturer(Integer lecturerId, LecturerRequestDto lecturerRequestDto);

    CompletableFuture<Void> deleteLecturer(Integer lecturerId);

    CompletableFuture<List<LecturerResponseDto>> getAllLecturers();

    CompletableFuture<LecturerResponseDto> getLecturerById(Integer lecturerId);
}
