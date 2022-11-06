package com.Proyecto.concesionario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String index(){
        return "/login";     //Este login si es el de nuestro html
    }
    
    @PostMapping("/login")
    public String login() {
        return "redirect:/home";
    }
}
