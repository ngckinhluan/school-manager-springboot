package com.naul2k.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
    


    // Navigation Properties
    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;

   
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
}
