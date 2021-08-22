package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentDto {
    private Integer id;
    private String name;
    private Integer age;

    public StudentDto() {
    }

    public StudentDto(Integer id, String name, Integer age) {
    }
}
