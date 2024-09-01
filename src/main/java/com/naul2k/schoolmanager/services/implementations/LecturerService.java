package com.naul2k.schoolmanager.services.implementations;

import com.naul2k.schoolmanager.dto.request.LecturerRequestDto;
import com.naul2k.schoolmanager.dto.response.LecturerResponseDto;
import com.naul2k.schoolmanager.entities.Course;
import com.naul2k.schoolmanager.entities.Lecturer;
import com.naul2k.schoolmanager.mapper.ILecturerMapper;
import com.naul2k.schoolmanager.repositories.interfaces.ILecturerRepository;
import com.naul2k.schoolmanager.services.interfaces.ILecturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class LecturerService implements ILecturerService {
    private final ILecturerRepository _repository;
    private final ILecturerMapper _mapper;

    public LecturerService(ILecturerRepository repository, ILecturerMapper mapper) {
        _repository = repository;
        _mapper = mapper;
    }

    @Override
    public CompletableFuture<Void> createLecturer(LecturerRequestDto lecturerRequestDto) {
        Lecturer lecturer = _mapper.toEntity(lecturerRequestDto);
        _repository.save(lecturer);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> updateLecturer(Integer lecturerId, LecturerRequestDto lecturerRequestDto) {
        return CompletableFuture.runAsync(() -> {
            Lecturer lecturer = _mapper.toEntity(lecturerRequestDto);
            lecturer.setLecturerId(lecturerId);
            _repository.save(lecturer);
        });
    }

    @Override
    public CompletableFuture<Void> deleteLecturer(Integer lecturerId) {
        return CompletableFuture.runAsync(() -> {
            _repository.deleteById(lecturerId);
        });
    }

    @Override
    public CompletableFuture<List<LecturerResponseDto>> getAllLecturers() {
        return CompletableFuture.supplyAsync(() -> {
            List<Lecturer> lecturers = _repository.findAll();
            return lecturers.stream()
                    .map(_mapper::toDto)
                    .collect(Collectors.toList());
        });
    }

    @Override
    public CompletableFuture<LecturerResponseDto> getLecturerById(Integer lecturerId) {
        return CompletableFuture.supplyAsync(() -> {
            Lecturer lecturer = _repository.findById(lecturerId).orElse(null);
            return _mapper.toDto(lecturer);
        });
    }
}
