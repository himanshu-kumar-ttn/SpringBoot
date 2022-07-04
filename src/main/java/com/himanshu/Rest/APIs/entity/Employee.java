package com.himanshu.Rest.APIs.entity;

import javax.persistence.*;

// To make this particular class as an entity so that it can interact with our database using JPA
//@Entity annotation specifies that this Java class is mapped to the database table.
@Entity
@Table(name = "employee")
public class Employee {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    Long id;  // id is marked with more JPA annotations to indicate it’s the primary key and automatically populated by the JPA provider.


    @Column(name = "name")
    private String name;
    @Column(name = "age")
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
