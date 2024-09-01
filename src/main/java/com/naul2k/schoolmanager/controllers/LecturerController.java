package com.naul2k.schoolmanager.controllers;
import com.naul2k.schoolmanager.dto.request.LecturerRequestDto;
import com.naul2k.schoolmanager.dto.response.LecturerResponseDto;
import com.naul2k.schoolmanager.services.interfaces.ILecturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/lecturers")
public class LecturerController {
    private final ILecturerService _service;

    public LecturerController(ILecturerService service) {
        _service = service;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<Void>> createLecturer(@RequestBody LecturerRequestDto lecturerRequestDto) {
        return _service.createLecturer(lecturerRequestDto)
                .thenApply(result -> ResponseEntity.status(HttpStatus.CREATED).build());
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<LecturerResponseDto>> getLecturerById(@PathVariable("id") Integer lecturerId) {
        return _service.getLecturerById(lecturerId)
                .thenApply(lecturerDto -> {
                    if (lecturerDto != null) {
                        return ResponseEntity.ok(lecturerDto);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> updateLecturer(@PathVariable("id") Integer lecturerId,
                                                                  @RequestBody LecturerRequestDto lecturerRequestDto) {
        return _service.updateLecturer(lecturerId, lecturerRequestDto)
                .thenApply(result -> ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteLecturer(@PathVariable("id") Integer lecturerId) {
        return _service.deleteLecturer(lecturerId)
                .thenApply(result -> ResponseEntity.noContent().build());
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<LecturerResponseDto>>> getAllLecturers() {
        return _service.getAllLecturers()
                .thenApply(lecturerDtos -> ResponseEntity.ok(lecturerDtos));
    }
}
