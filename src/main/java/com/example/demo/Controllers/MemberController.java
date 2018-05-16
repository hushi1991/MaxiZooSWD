package com.example.demo.Controllers;

import com.example.demo.Model.Entities.Member;
import com.example.demo.Model.Repositories.IMemberRepo;
import com.example.demo.Model.Repositories.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    IMemberRepo memberRepo = new MemberRepo();

    @GetMapping("/createMember")
    public String employee(Model model, HttpSession session) {

        model.addAttribute("member", new Member());

        if (sessionController(session)){
            return "CreateMember";
        } else {
            return "login";
        }
    }

    @PostMapping("/createMember")
    public String createMember(@ModelAttribute Member member, Model model){

        memberRepo.createMember(member);

        return "index";
    }

    private boolean sessionController(HttpSession session){
        if(session.getAttribute("status") != null && session.getAttribute("status").equals("1")){
            return true;
        } else {
            return false;
        }
    }
}
