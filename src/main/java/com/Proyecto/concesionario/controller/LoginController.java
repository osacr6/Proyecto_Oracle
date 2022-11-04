package com.Proyecto.concesionario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String index(){
        return "/login";     //Este login si es el de nuestro html
    }
}
