package com.himanshu.Rest.APIs.controller;

import com.himanshu.Rest.APIs.entity.Employee;
import com.himanshu.Rest.APIs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@RequestMapping annotation on the class defines a base URL for all the REST APIs created in this controller.
public class EmployeeController {

    // this is the particular employeeService I want from soring for that I will write @Autowired
    @Autowired // so that particular object that spring has will be attached to this particular reference I have created
    // i.e autowired using @Autowired annotation we used ioc and dependency injection from spring
    // this autowired will wire that particular object with the reference I have created
    // now there are two types of auto wiring or two types of dependency injection that we can do is
//    one is constructor based and one is setter based here we are using is property based
    private EmployeeService employeeService;

    //POST
    @PostMapping("/employees")
    // convert the json object receiving from the client to Employee entity
    // @RequestBody annotation -> whatever the data you are getting as a request body(json)
    // get that particular json and convert it into my Employee object here
//    @RequestBody annotation is used to map the request body of the endpoint to the method parameter.
    public Employee createEmployee(@RequestBody Employee employee) {
        // we are using spring and spring already knows that we already have that particular
//        employee service, employee service implementation and so on this we are doing using new keyword spring already have this we shouldn't be doing this
//        EmployeeService service = new EmployeeServiceImpl();
        return employeeService.createEmployee(employee);
    }

    //GET
    @GetMapping("/employees")
    public List<Employee> readEmployees() {
        return employeeService.getEmployees();
    }

    //PUT
//    @PathVariable, meaning that the API endpoint has a path parameter involved.
//    The @PathVariable will map the path variable provided in the value parameter of the endpoint to the Java method field.
    @PutMapping("/employees/{employeeId}")
    public Employee readEmployees(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employeeDetail) {
        return employeeService.updateEmployee(employeeId, employeeDetail);
    }


    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployees(@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployee(id);
    }


}
