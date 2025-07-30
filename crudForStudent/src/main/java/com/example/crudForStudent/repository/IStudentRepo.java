package com.example.crudForStudent.repository;


import com.example.crudForStudent.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Students, Integer> {
}
