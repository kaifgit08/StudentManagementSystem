package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
//    Student getStudentByRoleNumber(String roleNumber);
    void deleteStudent(int id);
    Student upateStudent(Student student,int id);
    Student getStudentById(int id);
    Student createStudent (Student student);
}