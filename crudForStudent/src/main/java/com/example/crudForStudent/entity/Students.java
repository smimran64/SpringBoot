package com.example.crudForStudent.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roll;
    private String name;
    private String marks;
    private String subject;


    public Students() {
    }

    public Students(int roll, String name, String marks, String subject) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        this.subject = subject;
    }

    public Students(String name, String marks, String subject) {
        this.name = name;
        this.marks = marks;
        this.subject = subject;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
