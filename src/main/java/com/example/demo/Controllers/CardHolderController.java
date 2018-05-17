package com.example.demo.Controllers;


import com.example.demo.Model.Entities.Card;
import com.example.demo.Model.Entities.CardHolder;
import com.example.demo.Model.Repositories.CardRepo;
import com.example.demo.Model.Repositories.CardholderRepo;
import com.example.demo.Model.Repositories.EmployeeRepo;
import com.example.demo.Model.Repositories.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    @GetMapping("/createCardHolder")
    public String createCardHolder(Model model, HttpSession session) {
        model.addAttribute("cardholder", new CardHolder());
        model.addAttribute("card", new Card());

        if (sessionController(session)){
            return "createCardHolder";
        } else {
            return "login";
        }
    }


    @PostMapping("/createCardHolder")
    public String createMember(@ModelAttribute CardHolder cardHolder, Card card, @RequestParam String mail, @RequestParam String empId){
        cahoRepo.createCardHolder(cardHolder, card, mail, empId);
        return "redirect:/employeeIndex";
    }

    //Søge funktion.
    @RequestMapping(value = {"/searchCardHolder"}, method = RequestMethod.GET)
    public String search(HttpSession session) {

        if(sessionController(session)){
            return "searchCardHolder";
        }
        else {
            return "login";
        }
    }


    //Hvis tlf nr passer i DB vises den rigtige kunde.
    @RequestMapping(value = "/searchCardHolder", method = RequestMethod.POST)
    public String searchphone(Model model, @RequestParam String phone) {
        if (cahoRepo.search(phone) != null) {
            CardHolder cardholder = cahoRepo.search(phone);
            model.addAttribute("cardholder", cardholder);
            model.addAttribute("member", cardholder.getMember());
            model.addAttribute("card", cardholder.getCard());
            model.addAttribute("employee", cardholder.getEmployee());
            return "cardholderDetails";
        }
        //Hvis nummeret ikke passer, eller der findes ingen match, så bliver man på søgesiden
        return "searchCardHolder";
    }

    /*@GetMapping("/cardholderDetails")
    public String showCardHolderDetails(@RequestParam int id, Model model){
        CardHolder cardholder = cahoRepo.read(id);
        model.addAttribute("cardholder", cardholder);
        model.addAttribute("member", cardholder.getMember());
        model.addAttribute("card", cardholder.getCard());
        model.addAttribute("employee", cardholder.getEmployee());
        System.out.println(cardholder);
        return "cardholderDetails";
    }*/

    @GetMapping("/deleteCardHolder")
    public String delete(@RequestParam("id") Integer id){
        cahoRepo.deleteCardHolder(id);
        return "redirect:/employeeIndex";
    }

    @GetMapping("/editCardHolder")
    public String editCardHolder(@RequestParam("id") int id, Model model){
        model.addAttribute("cardholder", cahoRepo.read(id));
        return "editCardHolder";
    }

    @PostMapping("/editCardHolder")
    public String editCardHOlder(@ModelAttribute CardHolder ch, Model model){
        cahoRepo.updateCardHolder(ch);
        return "redirect:/employeeIndex";
    }

    private boolean sessionController(HttpSession session){
        if(session.getAttribute("status") != null && session.getAttribute("status").equals("1")){
            return true;
        } else {
            return false;
        }
    }
}

