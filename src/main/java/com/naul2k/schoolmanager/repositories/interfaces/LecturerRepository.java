package com.naul2k.schoolmanager.repositories.interfaces;

import com.naul2k.schoolmanager.entities.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
    List<Lecturer> findLecturerByEmail(String email);
}
