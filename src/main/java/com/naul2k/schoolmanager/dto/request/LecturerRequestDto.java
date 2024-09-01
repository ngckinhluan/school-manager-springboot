package com.naul2k.schoolmanager.dto.request;

import jakarta.persistence.Column;

public class LecturerRequestDto {
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = true, length = 20)
    private String phoneNumber;
}
