package aman.irshad.springbootrestapi.controller;

import aman.irshad.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // HTTP GET Request
    // http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Ramesh",
                "Fadatare"
        );
        //return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header","Aman")
                .body(student);
    }

    // HTTP GET Request
    // http://localhost:8080/students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ramesh","Fadatare"));
        students.add(new Student(2,"Umesh","Fadatare"));
        students.add(new Student(3,"Ram","Jadhav"));
        students.add(new Student(4,"Sanjay","Pawar"));
        //return students;
        return ResponseEntity.ok(students);
    }


    // Spring Boot REST API with Path Variable
    // {id} - URI Template Variable
    // http://localhost:8080/students/1/ramesh/fadatare
    // @PathVariable - to bind method argument to uri template variable
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        //return new Student(studentId,firstName,lastName);
        Student student = new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
    }


    // Spring Boot REST API Request Param
    // http://localhost:8080/students/query?id=1&firstName=Aman&lastName=Irshad
    // we used students/query because it has to be unique and we already have defined
    // /students endpoint
    @GetMapping("/students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        //return new Student(id,firstName,lastName);
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP POST request - creating new resource
    // @PostMapping and @RequestBody
    // @RequestBody internally uses HttpMessageConverter to convert JSON to Java Object
    // @ResponseStatus to return a status code by default 200
    @PostMapping("/students/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        //return student;
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot REST API that handles HTTP PUT request - updating existing resource
    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        //return student;
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP DELETE request - deleting existing resource
    @DeleteMapping("/students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        //return "Student Deleted Successfully";
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}
