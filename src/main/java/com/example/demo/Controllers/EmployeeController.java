package com.example.demo.Controllers;

import com.example.demo.Model.Entities.Employee;
import com.example.demo.Model.Entities.Member;
import com.example.demo.Model.Repositories.EmployeeRepo;
import com.example.demo.Model.Repositories.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    IEmployeeRepo employeeRepo = new EmployeeRepo();

    @GetMapping("/createEmployee")
    public String employee(Model model) {

        model.addAttribute("employee", new Employee());

        return "createEmployee";
    }

    @PostMapping("/createEmployee")
    public String createMember(@ModelAttribute Employee employee, Model model){

        employeeRepo.createEmployee(employee);

        return "index";
    }
}
