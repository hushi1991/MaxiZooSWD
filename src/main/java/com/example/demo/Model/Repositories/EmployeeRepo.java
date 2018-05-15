package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo implements IEmployeeRepo {

    @Autowired
    private JdbcTemplate jdbc;


    //Det Employee objekt der gives i parametret bliver skabt i DB.
    @Override
    public void createEmployee(Employee employee){

        jdbc.update("INSERT INTO maxi_zoo.employee(name, status, phone) VALUES('" + employee.getName() +"', '"+ employee.getStatus() +"', '"+ employee.getPhone() +"')");

    }

    @Override
    public Employee read(int id) {
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.employee WHERE id =" + id + "");

        if (sqlRowSet.next()){
            return new Employee(sqlRowSet.getInt("id"), sqlRowSet.getString("name"), sqlRowSet.getString("status"), sqlRowSet.getString("phone"));
        }
        return new Employee();
    }
}
