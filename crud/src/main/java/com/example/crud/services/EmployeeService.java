package com.example.crud.services;


import com.example.crud.entity.Employee;
import com.example.crud.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepo repo;

    public List<Employee>getAll(){

        return repo.findAll();
    }


    public Employee getById(Long id){

        return repo.findById(id).orElse(null);

    }

    public void save(Employee employee){

        repo.save(employee);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

}
