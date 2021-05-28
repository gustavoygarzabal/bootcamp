package com.globant.bootcamp.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/user/signIn")
    public String register() {
        return "/user/register";
    }

    @GetMapping("/user/logIn")
    public String logIn() {
        return "/user/logIn";
    }

    @RequestMapping("/user/successSignIn")
    public String processSignIn(HttpServletRequest request, Model model) {
        //Adding info to the model
        model.addAttribute("userName", request.getParameter("userName"));
        model.addAttribute("userPassword", request.getParameter("userPassword"));
        model.addAttribute("userEmail", request.getParameter("userEmail"));

        return "user/successSignIn";
    }

}
