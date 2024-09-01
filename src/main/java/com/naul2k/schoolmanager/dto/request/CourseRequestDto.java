package com.naul2k.schoolmanager.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDto {
    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;

    @Column(name = "course_description", nullable = true, length = 255)
    private String courseDescription;
}
