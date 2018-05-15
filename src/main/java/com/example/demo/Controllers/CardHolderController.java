package com.example.demo.Controllers;


import com.example.demo.Model.Repositories.CardRepo;
import com.example.demo.Model.Repositories.CardholderRepo;
import com.example.demo.Model.Repositories.EmployeeRepo;
import com.example.demo.Model.Repositories.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

}
