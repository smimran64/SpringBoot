package com.example.crudForStudent.service;


import com.example.crudForStudent.entity.Students;
import com.example.crudForStudent.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private IStudentRepo studentRepo;



    public List<Students> getAll() {

        return studentRepo.findAll();
    }

    public Students getById(int id) {
        return studentRepo.findById(id).orElse(null);
    }


    public void save(Students students) {

        studentRepo.save(students);
    }

    public void delete(int id) {
        studentRepo.deleteById(id);
    }


}
