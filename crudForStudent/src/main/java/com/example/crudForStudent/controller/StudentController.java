package com.example.crudForStudent.controller;


import com.example.crudForStudent.entity.Students;
import com.example.crudForStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("studentForm")
    public String studentForm(Model model) {
        model.addAttribute("student", new Students());
        return "addStudent";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Students students) {

        studentService.save(students);

        return "redirect:/";
    }


    @GetMapping("")
    public String getAllStudents(Model model) {

        List <Students> list = studentService.getAll();

        model.addAttribute("list", list);


        return "home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        Students student = studentService.getById(id);
        model.addAttribute("student", student);



        return "addStudent";

    }

    @GetMapping("/delete/{id}")
    public String delete(int id) {
        studentService.delete(id);
        return "redirect:/";
    }

}
