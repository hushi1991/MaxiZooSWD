package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeRepo implements IEmployeeRepo {

    @Autowired
    private JdbcTemplate jdbc;


    //Det Employee objekt der gives i parametret bliver skabt i DB.
    @Override
    public void createEmployee(Employee employee){
        /*
        jdbc.update("INSERT INTO employees(name, totalHours) VALUES('" + employee.getName() +"', '"+ employee.getTotalHours() +"')");
        */
    }
}
