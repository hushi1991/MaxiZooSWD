package com.example.demo.Controllers;


import com.example.demo.Model.Entities.Member;
import com.example.demo.Model.Repositories.IMemberRepo;
import com.example.demo.Model.Repositories.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    IMemberRepo memberRepo = new MemberRepo();

    @RequestMapping(value = {"","/","index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @GetMapping("/employeecreate")
    public String employee(Model model) {

        model.addAttribute("employee", new Member());

        return "employeecreate";
    }

    //Den indtastede information til medarbejderen gemmes og bliver gemt i DB.
    @PostMapping("/employeecreate")
    public String createEmployee(@ModelAttribute Member member, Model model){

        memberRepo.createMember(member);

        /*
        employees = employRepo.readAll();
        model.addAttribute("e", employees);

        */
        return "adminemployee";
    }
}
