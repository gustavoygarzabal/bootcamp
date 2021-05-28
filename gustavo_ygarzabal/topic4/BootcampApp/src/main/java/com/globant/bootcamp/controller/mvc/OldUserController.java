package com.globant.bootcamp.controller.mvc;

import com.globant.bootcamp.model.SimplerUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class OldUserController {

    @RequestMapping("/showForm")
    public String showForm(Model model){
        SimplerUser user = new SimplerUser();
        model.addAttribute("user", user);

        return "user/userShowForm";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("user") SimplerUser user) {

        return "user/confirmationSignIn";
    }

}
