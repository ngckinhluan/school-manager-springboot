package com.naul2k.schoolmanager.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDto {
    private String courseName;
    private String courseDescription;
}
