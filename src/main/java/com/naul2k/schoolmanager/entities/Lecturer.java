package com.naul2k.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Lecturer")
@Builder
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private Integer lecturerId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "phone_number", nullable = true, length = 20)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    
}
