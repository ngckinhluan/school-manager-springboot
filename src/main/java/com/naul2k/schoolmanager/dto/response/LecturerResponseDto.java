package com.naul2k.schoolmanager.dto.response;

import lombok.Data;

@Data
public class LecturerResponseDto {
    private Integer lecturerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
