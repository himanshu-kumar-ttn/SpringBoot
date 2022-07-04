package com.himanshu.Rest.APIs.controller;

import org.springframework.web.bind.annotation.*;

//@Component
// Technically it is not a simple class it is a controller or say resource
//@Controller // this will be behaved as a component by default, my controller still have to be rest controller
@RestController // This will tell this is a particular controller as a component + it will tell that it always return a response body
//so whatever i will be doing in this class will be my rest end point
public class HelloController {


//    @RequestMapping(value = "/", method = RequestMethod.GET)  // This particular line is still verbose
    @GetMapping("/")
    public String helloWorld(){
        return "Welcome to spring boot";
    }

//    @GetMapping("/hello")
//    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return String.format("Hello %s!", name);
//    }

}
