package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentCreationDto {
    private List<StudentDto> students;

    public StudentCreationDto(List<StudentDto> students) {
        this.students = students;
    }

    public StudentCreationDto() {
        this(new ArrayList<>());
    }

    public void addStudent(StudentDto student) {
        this.students.add(student);
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }
}
