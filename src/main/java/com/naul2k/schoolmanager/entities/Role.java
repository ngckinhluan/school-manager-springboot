package com.naul2k.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Role")
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name", nullable = false, unique = true, length = 50)
    private String roleName;
    @Column(name = "role_description", nullable = true, unique = true, length = 255)
    private String roleDescription;
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
    // Default value is false
    
    // Navigation Properties
    @OneToMany(mappedBy = "role")
    private List<Lecturer> lecturers;
    
   
    
    
}
