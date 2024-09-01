package com.naul2k.schoolmanager.dto.response;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponseDto {
   
    private Integer courseId;

    private String courseName;

    private String courseDescription;
}
