package com.Proyecto.concesionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
    
    @GetMapping("/registro")
    public String registro(){
        return "/registro";
    }
    
    @PostMapping("/registro")
    public ModelAndView registro(
        @RequestBody String payload,
        @RequestParam("username") String username,
        @RequestParam("password") String password, 
        @RequestParam("passwordcheck") String passwordcheck
    ){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("encodedPassword --> " + password + " = " + encodedPassword);
        
        // USERNAME, PASSWORD, ROL_ID, ACTIVE
        this.jdbcTemplate.update("CALL sp_crear_usuario(?, ?, 3, 1)", username, encodedPassword); 
        return new ModelAndView("/login");
    }
}
