﻿package com.naul2k.schoolmanager.repositories.interfaces;

import com.naul2k.schoolmanager.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
    
}
