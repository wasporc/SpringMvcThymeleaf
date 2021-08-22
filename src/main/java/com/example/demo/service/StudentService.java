package com.example.demo.service;

import com.example.demo.dto.StudentCreationDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentsRepository studentsRepository;

    private final Function<Student, StudentDto> functionStudentMapper = student -> {
        StudentDto studentdto = new StudentDto();
        studentdto.setId(student.getId());
        studentdto.setName(student.getName());
        studentdto.setAge(student.getAge());
        return studentdto;
    };


    public List<StudentDto> getAll(){
        return studentsRepository.findAll()
                .stream()
                .map(functionStudentMapper)
                .collect(Collectors.toList());
    }

    public void save(Student student){
        if (student != null){
            studentsRepository.save(student);
        }
    }

    public void update(Student student){
        if (student != null){
            studentsRepository.save(student);
        }
    }

    public void delete(Student student){
        studentsRepository.delete(student);
    }

    public StudentDto findById(Integer id){
        Optional<Student> studentOptional = studentsRepository.findById(id);
        if (studentOptional.isPresent()){
            return studentOptional.map(functionStudentMapper).get();
        }
        else return null;
    }

    public void saveAll(StudentCreationDto students){
        students.getStudents().stream()
                .map(studentDto -> {
                    Student student = new Student();
                    student.setAge(studentDto.getAge());
                    student.setId(studentDto.getId());
                    student.setName(studentDto.getName());
                    return student;
                }).forEach(this::save);

    }
}
