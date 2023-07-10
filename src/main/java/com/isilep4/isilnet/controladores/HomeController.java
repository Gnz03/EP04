package com.isilep4.isilnet.controladores;


import com.isilep4.isilnet.repositorios.UserRepository;
import com.isilep4.isilnet.entidades.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPass().equals(user.getPass())) {
            return "exito";
        } else {
            return "error";
        }
    }
}

