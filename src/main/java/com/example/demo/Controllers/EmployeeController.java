package com.example.demo.Controllers;

import com.example.demo.Model.Entities.Employee;
import com.example.demo.Model.Entities.Member;
import com.example.demo.Model.Repositories.EmployeeRepo;
import com.example.demo.Model.Repositories.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    @Autowired
    IEmployeeRepo employeeRepo = new EmployeeRepo();

    @RequestMapping(value = {"employeeIndex"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpSession session) {

        if (sessionController(session)){
            return "employeeIndex";
        } else {
            return "login";
        }
    }

    @GetMapping("/createEmployee")
    public String employee(Model model, HttpSession session) {
        model.addAttribute("employee", new Employee());

        if (sessionController(session)){
            return "createEmployee";
        } else {
            return "login";
        }
    }

    @PostMapping("/createEmployee")
    public String createMember(@ModelAttribute Employee employee, Model model){
        employeeRepo.createEmployee(employee);
        return "employeeIndex";
    }

    private boolean sessionController(HttpSession session){
        if(session.getAttribute("status") != null && session.getAttribute("status").equals("1")){
            return true;
        } else {
            return false;
        }
    }

}
