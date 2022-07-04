package com.himanshu.Rest.APIs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

// To make this particular class as an entity so that it can interact with our database using JPA
//@Entity annotation specifies that this Java class is mapped to the database table.

// Hibernate validation
// whenever i am getting the data as an input from the json i want
//my employee always if i am not having age its fine but its mandatory to have employee name

@Entity
public class Employee {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;  // id is marked with more JPA annotations to indicate it’s the primary key and automatically populated by the JPA provider.


    // particular validation
   @NotBlank(message = "Please Add Employee Name")
    private String name;

    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
