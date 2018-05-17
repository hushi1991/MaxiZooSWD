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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    IMemberRepo memberRepo = new MemberRepo();

    @GetMapping("/createMember")
    public String employee(Model model, HttpSession session) {
        model.addAttribute("member", new Member());
        return "CreateMember";
    }

    @PostMapping("/createMember")
    public String createMember(@ModelAttribute Member member, Model model){

        memberRepo.createMember(member);

        return "index";
    }

    @GetMapping("/memberReceipt")
    public String memberReceipt(@RequestParam("id") int id, Model model){
        model.addAttribute("member", memberRepo.read(id));
        return "memberReceipt";
    }
}
