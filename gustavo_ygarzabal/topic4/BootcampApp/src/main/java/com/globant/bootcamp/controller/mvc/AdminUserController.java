package com.globant.bootcamp.controller.mvc;

import com.globant.bootcamp.controller.mvc.dto.UserDto;
import com.globant.bootcamp.rest.entity.User;
import com.globant.bootcamp.rest.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    Logger logger = Logger.getLogger(AdminUserController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String showUser(Model model) {
        model.addAttribute("newUser", new UserDto());

        List<UserDto> userDtos = mapToListUserDto(userService.findAll());
        model.addAttribute("users", userDtos);
        return "admin/adminPage";
    }

    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/update")
    public String updateUserForm(Model model,
                                 @RequestParam String id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String address,
                                 @RequestParam String password){

        model.addAttribute("newUser", new UserDto());
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("address", address);
        model.addAttribute("password", password);

        List<UserDto> userDtos = mapToListUserDto(userService.findAll());
        model.addAttribute("users", userDtos);

        return "/admin/adminPage";
    }

    @RequestMapping("/makeInsert")
    public String makeInsert(@ModelAttribute("newUser") UserDto user){

        userService.save(new User(
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getPassword()));
        return "redirect:/admin";

    }

    @RequestMapping("/makeUpdate")
    public String makeUpdate(@ModelAttribute("newUser") UserDto user){

        User newUser = new User(
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getPassword());
        userService.updateUserById(user.getId(), newUser);
        return "redirect:/admin";

    }


    public List<UserDto> mapToListUserDto(List<User> userList) {
        List<UserDto> userDtos = new ArrayList<>();
        for(User user: userList) {
            userDtos.add(
                    new UserDto(
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getPassword(),
                            user.getAddress(),
                            "CLIENT"
                    )
            );
        }
        return userDtos;
    }


}
