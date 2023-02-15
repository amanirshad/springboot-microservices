package aman.irshad.springbootrestapi.controller;

import aman.irshad.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    // HTTP GET Request
    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Ramesh",
                "Fadatare"
        );
        return student;
    }
}
