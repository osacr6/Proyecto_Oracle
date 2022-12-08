package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.Rol;
import com.Proyecto.concesionario.repository.RolRepository;
import java.util.List;
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
    @Autowired
    private RolRepository rolRepository;
    
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
    
    @GetMapping("/registro")
    public String registro(){
        return "/registro";
    }
    
    @PostMapping("/registro")
    public String registro(
        @RequestBody String payload,
        @RequestParam("username") String username,
        @RequestParam("password") String password, 
        @RequestParam("passwordcheck") String passwordcheck
    ) {
        Rol rol = (Rol)this.rolRepository.findByName("USER");
        long rolId = rol.getRolId();
        
        if(rol != null)  {
            rolId = rol.getRolId();
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            System.out.println("encodedPassword --> " + password + " = " + encodedPassword);

            // USERNAME, PASSWORD, ROL_ID, ACTIVE
            this.jdbcTemplate.update(
                "CALL sp_crear_usuario(?, ?, 3, 1)",
                username, 
                encodedPassword
            );

            return "redirect:/usuarios";
        } else {
            return "redirect:/usuarios";
        }
    }
}
