package com.naul2k.schoolmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naul2k.schoolmanager.controllers.CourseController;
import com.naul2k.schoolmanager.dto.request.CourseRequestDto;
import com.naul2k.schoolmanager.dto.response.CourseResponseDto;
import com.naul2k.schoolmanager.services.interfaces.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        // Initialization code if needed
    }

    @Test
    void testGetAllCourses() throws Exception {
        when(courseService.getAllCourses()).thenReturn(
                List.of(new CourseResponseDto(1, "Course Name", "Course Description"))
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/api/courses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].courseName").value("Course Name"));
    }

    @Test
    void testGetCourseById() throws Exception {
        when(courseService.getCourseById(1)).thenReturn(
                new CourseResponseDto(1, "Course Name", "Course Description")
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/api/courses/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseName").value("Course Name"));
    }

    @Test
    void testAddCourse() throws Exception {
        CourseRequestDto requestDto = new CourseRequestDto("New Course", "Description");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(courseService, times(1)).addCourse(any(CourseRequestDto.class));
    }

    @Test
    void testUpdateCourse() throws Exception {
        CourseRequestDto requestDto = new CourseRequestDto("Updated Course", "Updated Description");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/courses/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        verify(courseService, times(1)).updateCourse(eq(1), any(CourseRequestDto.class));
    }

    @Test
    void testDeleteCourse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/courses/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        verify(courseService, times(1)).deleteCourse(eq(1));
    }
}
