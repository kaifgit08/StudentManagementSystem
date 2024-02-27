package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentServiceImpl;
@RestController
@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
    private  StudentServiceImpl service;
	
	@PostMapping
	ResponseEntity<Student> createToDo(@RequestBody Student student) {
		service.createStudent(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	ResponseEntity<Student> updateToDoById(@PathVariable("id") int id, @RequestBody Student student) {
		System.out.println("Update method reached");
		Student d = service.upateStudent(student, id);
		return new ResponseEntity(d, HttpStatus.OK);
	}

	@GetMapping("{id}")
	ResponseEntity<Student> getToDoById(@PathVariable("id") int id) {
		Student d = service.getStudentById(id);
		return new ResponseEntity(d, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	ResponseEntity<Student> deleteById(@PathVariable("id") int id) {
		service.deleteStudent(id);
		return new ResponseEntity("StudentRecord deleted successfully", HttpStatus.OK);
	}

	@GetMapping
	ResponseEntity<List<Student>> getAllToDo() {
		List<Student> list = service.getAllStudents();
		return new ResponseEntity(list, HttpStatus.OK);
	}


//    @GetMapping("/search")
//    public String searchStudents(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
//        List<Student> searchResults = studentService.searchStudents(keyword);
//        model.addAttribute("students", searchResults);
//        return "studentList";
//    }
//    @Controller
//    public class CustomErrorController implements ErrorController {
//
//        @RequestMapping("/error")
//        public String handleError(HttpServletRequest request) {
//            Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//            if (status != null) {
//                int statusCode = Integer.parseInt(status.toString());
//
//                if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                    return "error-404";
//                } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                    return "error-500";
//                }
//            }
//
//            return "error";
//        }
//
//        @Override
//        public String getErrorPath() {
//            return "/error";
//        }
//    }
}