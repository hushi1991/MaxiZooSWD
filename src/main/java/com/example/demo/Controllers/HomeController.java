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



    @GetMapping("/createMember")
    public String employee(Model model) {

        model.addAttribute("member", new Member());

        return "createMember";
    }

    @PostMapping("/createMember")
    public String createMember(@ModelAttribute Member member, Model model){

        memberRepo.createMember(member);

        return "index";
    }


}
