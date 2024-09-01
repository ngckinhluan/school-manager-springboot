package com.naul2k.schoolmanager.repositories.interfaces;

import com.naul2k.schoolmanager.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
