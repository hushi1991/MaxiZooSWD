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
    public String createCardHolder(Model model) {
        model.addAttribute("cardholder", new CardHolder());
        model.addAttribute("card", new Card());
        return "createCardHolder";
    }


    @PostMapping("/createCardHolder")
    public String createMember(@ModelAttribute CardHolder cardHolder, Card card, @RequestParam String mail, @RequestParam String empId){

        cahoRepo.createCardHolder(cardHolder, card, mail, empId);

        return "index";
    }

    //Søge funktion.
    @RequestMapping(value = {"/searchCardHolder"}, method = RequestMethod.GET)
    public String search() {
        return "searchCardHolder";
    }

    //Hvis tlf nr passer i DB vises den rigtige kunde.
    @RequestMapping(value = "/searchCardHolder", method = RequestMethod.POST)
    public String phonelogin(Model model, @RequestParam String phone) {
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
}

