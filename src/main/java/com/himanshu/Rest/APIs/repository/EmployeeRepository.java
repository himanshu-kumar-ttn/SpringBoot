package com.himanshu.Rest.APIs.repository;

import com.himanshu.Rest.APIs.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//Spring Data JPA repositories are interfaces with methods supporting creating, reading, updating,
// and deleting records against a back end data store.

//Spring makes accessing data easy. By simply declaring the following EmployeeRepository interface we automatically will be able to
//        Create new Employees
//        Update existing ones
//        Delete Employees
//        Find Employees (one, all, or search by simple or complex properties)

//        To get all this free functionality, all we had to do was declare an interface which extends Spring Data JPA’s JpaRepository,
//        specifying the domain type as Employee and the id type as Long.

// The @Repository on the class indicates that the class is a data repository that will contain CRUD operations.
// CRUD is an acronym that stands for the four basic operations of the database - Create, Read, Update, Delete.

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    You have two parameters passed to the JpaRepository - first parameter is the model class that will be managed by this repository, second is the data type of the primary key.

    public Employee findByName(String name);
    public Employee findByNameIgnoreCase(String name);

    public Employee findByAge(Integer age);




    // lets say there's no method for findByNameIgnoreCase or the query is complex
//    in that case we can go for JPQL and if we are not able to go ahead with JPQL as well then
//            we can go for native sql as well for that case we can pass native sql as well
//  example
//    @Query("?1")     //jpql
//    @Query(value = "", nativeQuery = true) // native query
//    public Employee findByNameIgnoreCase(String name);



    /// should return unique result
//    public Employee findByNameStartingWith(String ch);

}
