package com.himanshu.Rest.APIs.service;

import com.himanshu.Rest.APIs.entity.Employee;
import com.himanshu.Rest.APIs.error.EmployeeNotFoundException;
import com.himanshu.Rest.APIs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired // instantiate our class object
    private EmployeeRepository employeeRepository;

    //CREATE
    public Employee createEmployee(Employee employee) {
//        The parameter passed to the createEmployee method is the Employee model containing all the details to save.
        return employeeRepository.save(employee);
    }

    //READ
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // DELETE
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    // UPDATE
    public Employee updateEmployee(Long employeeId, Employee employeeDetails) {
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if (emp.isPresent()) {
            Employee emp1 = emp.get();
            emp1.setName(employeeDetails.getName());
            emp1.setAge(employeeDetails.getAge());
            return employeeRepository.save(emp1);
        }
        return null;
    }


    public Long countEmployee() {
        return employeeRepository.count();
    }

    // there is no default method available in the jpa repository so create a method in the employee repository ourselves
    public Employee getEmployeeByName(String name) {
//        return employeeRepository.findByName(name);
        return employeeRepository.findByNameIgnoreCase(name);
    }


    public Employee getEmployeeByAge(Integer age) {
        return employeeRepository.findByAge(age);
    }

    public List<Employee> getEmployeeByAgeInBetween() {
        return employeeRepository.findAll().stream().filter(employee -> employee.getAge() >= 20 && employee.getAge() <= 25).collect(Collectors.toList());
    }

    public List<Employee> getEmployeesWithNameChar(String ch) {
//        return employeeRepository.findByNameStartingWith(ch);
        return employeeRepository.findAll().stream().filter(employee -> employee.getName().startsWith(ch)).toList();
    }

    // find employeeById
    // Exceptional Handling what if with the certain id the enityt or
//    the employee is not present in that i want to throw custom exception
    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        // now will check whatever employee i am getting from the database is present or not
//        if it is present then its fine if it is not present then we should throw the employeeNotFound Exception
        if(!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee with the given id is not present");
        }
        // if found the employee
        return employee.get();
    }
}


