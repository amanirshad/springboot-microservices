package aman.irshad.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Controller - Instructs for being Spring MVC Controller
 * @ResponseBody - Instructs for returning JSON as Response to Java Objects
 * replaced with RestController
 * internally uses both
 */
@RestController
public class HelloWorldController {


    // HTTP GET Request
    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

}
