package com.himanshu.Rest.APIs.service;

import com.himanshu.Rest.APIs.entity.Employee;
import com.himanshu.Rest.APIs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    // DELETE
    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    // UPDATE
    public Employee updateEmployee(Long employeeId, Employee employeeDetails) {
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if(emp.isPresent()){
           Employee emp1 = emp.get();
            emp1.setName(employeeDetails.getName());
            emp1.setAge(employeeDetails.getAge());
            return employeeRepository.save(emp1);
        }
        return null;



    }



}


