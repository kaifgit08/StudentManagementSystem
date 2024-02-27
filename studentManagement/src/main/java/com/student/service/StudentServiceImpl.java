package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
    private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		List<Student> list=studentRepository.findAll();
		return list;
	}

	@Override
	public void deleteStudent(int id) {
		Student delete=studentRepository.findById(id).orElse(null);
		studentRepository.deleteById(id);
	}

	@Override
	public Student upateStudent(Student student, int id) {
		Student updateStudent=null;
		updateStudent=studentRepository.findById(id).orElse(null);
		updateStudent.setEnglish(student.getEnglish());
		updateStudent.setMaths(student.getMaths());
		updateStudent.setScience(student.getScience());
		updateStudent.setSocial(student.getSocial());
		updateStudent.setTamil(student.getTamil());
		updateStudent.setName(student.getName());
		updateStudent.setResult(student.getResult());
		updateStudent.setRollno(student.getRollno());
		
		return updateStudent;
	}

	@Override
	public Student getStudentById(int id) {
		Student get=studentRepository.findById(id).orElse(null);
		return get;
	}

	@Override
	public Student createStudent(Student student) {
		Student create=studentRepository.save(student);
		return create;
	}


}