package com.himanshu.Rest.APIs.controller;

import com.himanshu.Rest.APIs.entity.Employee;
import com.himanshu.Rest.APIs.error.EmployeeNotFoundException;
import com.himanshu.Rest.APIs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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

    // hibernate validation here we are getting data from client here is we are getting request body
    // @Valid annottion so whenever the request is coming to save the data from the post mapping that particular
//    json body will be validated against the name as we have marked it as @NotBlank
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
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
    public String deleteEmployees(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Employee deleted successfully!";
    }

    @GetMapping("/employees/count")
    public Long countEmployees() {
        return employeeService.countEmployee();
    }

    // get employee by id
    @GetMapping("employees/{employeeId}")
    public Employee getEmployeesById(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(employeeId);
    }

    // get employee by name
    @GetMapping("/employees/name/{name}")
    public Employee getEmployeesByName(@PathVariable("name") String name) {

        return employeeService.getEmployeeByName(name);
    }

    // get employee by age
    @GetMapping("/employees/age/{age}")
    public Employee getEmployeesByAge(@PathVariable("age") Integer age) {
        return employeeService.getEmployeeByAge(age);
    }


    //     employee between age of 20 to 30
    @GetMapping("/employees/age")
    public List<Employee> getEmployeesByAgeInBetween() {
        return employeeService.getEmployeeByAgeInBetween();
    }

    // employee whose name starts with char S or {char}
    @GetMapping("employees/char/{char}")
    public List<Employee> getEmployeesWithNameChar(@PathVariable("char") String ch) {
        return employeeService.getEmployeesWithNameChar(ch);
    }

}
