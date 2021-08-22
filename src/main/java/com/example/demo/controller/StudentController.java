package com.example.demo.controller;

import com.example.demo.dto.StudentCreationDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public String showAll(Model model){
        List<StudentDto> all = service.getAll();
        model.addAttribute("students", all);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        List<StudentDto> list = new ArrayList<>();
        list.add(service.findById(id));
        model.addAttribute("form", new StudentCreationDto(list));
        return "students/editStudentForm";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute StudentCreationDto form, Model model) {
        service.saveAll(form);
        model.addAttribute("students", service.getAll());
        return "redirect:/";
    }

}
