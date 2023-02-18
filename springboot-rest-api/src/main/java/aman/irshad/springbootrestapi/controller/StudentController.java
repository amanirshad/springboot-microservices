package aman.irshad.springbootrestapi.controller;

import aman.irshad.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    // HTTP GET Request
    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ramesh","Fadatare"));
        students.add(new Student(2,"Umesh","Fadatare"));
        students.add(new Student(3,"Ram","Jadhav"));
        students.add(new Student(4,"Sanjay","Pawar"));
        return students;
    }


    // Spring Boot REST API with Path Variable
    // {id} - URI Template Variable
    // http://localhost:8080/students/1/ramesh/fadatare
    // @PathVariable - to bind method argument to uri template variable
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
    }


    // Spring Boot REST API Request Param
    // http://localhost:8080/students/query?id=1&firstName=Aman&lastName=Irshad
    // we used students/query because it has to be unique and we already have defined
    // /students endpoint
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }
}
