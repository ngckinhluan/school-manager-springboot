package com.naul2k.schoolmanager.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Course")
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;

    @Column(name = "course_description", nullable = true, length = 255)
    private String courseDescription;
    
    // Navigation Properties
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
}
