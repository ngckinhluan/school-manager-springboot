package com.naul2k.schoolmanager.dto.response;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {

    private Integer courseId;

    private String courseName;

    private String courseDescription;
}
