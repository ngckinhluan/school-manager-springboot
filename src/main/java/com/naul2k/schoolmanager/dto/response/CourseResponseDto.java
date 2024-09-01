package com.naul2k.schoolmanager.dto.response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponseDto {
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private Boolean isDeleted;
}
