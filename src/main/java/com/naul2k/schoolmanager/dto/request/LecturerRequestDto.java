package com.naul2k.schoolmanager.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LecturerRequestDto {
    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
