package com.example.demo.Controllers;

import com.example.demo.Model.Entities.User;
import com.example.demo.Model.Repositories.IMemberRepo;
import com.example.demo.Model.Repositories.IUserRepo;
import com.example.demo.Model.Repositories.MemberRepo;
import com.example.demo.Model.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    IUserRepo userRepo = new UserRepo();


    @RequestMapping(value = {"","/","index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpSession session) {
        return "index";
    }

    @RequestMapping(value = {"loginTest"}, method = RequestMethod.GET)
    public String loginTest() {
        return "loginTest";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session){

        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){

        User dbUser = userRepo.login(user.getUsername(), user.getPassword());

        if (dbUser != null){

            User u = userRepo.login(user.getUsername(), user.getPassword());

            if (u.isAdmin() == true) {

                session.setAttribute("status", "1");
                System.out.println("Logget på");
            } else {
                session.setAttribute("status", "0");
                System.out.println("Ikke logget på");
                return "login";
            }
        }
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
