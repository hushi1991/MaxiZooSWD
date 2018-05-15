package com.example.demo.Controllers;


import com.example.demo.Model.Entities.CardHolder;
import com.example.demo.Model.Repositories.CardRepo;
import com.example.demo.Model.Repositories.CardholderRepo;
import com.example.demo.Model.Repositories.EmployeeRepo;
import com.example.demo.Model.Repositories.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CardHolderController {

    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private EmployeeRepo empRepo;
    @Autowired
    private MemberRepo memRepo;
    @Autowired
    private CardholderRepo cahoRepo;

    @GetMapping("/cardholderDetails")
    public String showCardHolderDetails(@RequestParam int id, Model model){
        CardHolder cardholder = cahoRepo.read(id);
        model.addAttribute("cardholder", cardholder);
        model.addAttribute("member", cardholder.getMember());
        model.addAttribute("card", cardholder.getCard());
        model.addAttribute("employee", cardholder.getEmployee());
        System.out.println(cardholder);
        return "cardholderDetails";
    }
}
