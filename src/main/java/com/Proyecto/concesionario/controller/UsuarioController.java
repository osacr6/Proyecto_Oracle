package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.Usuario;
import com.Proyecto.concesionario.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller 
public class UsuarioController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/usuarios") 
    public String index (Model model){
        List <Usuario> listarUsuario = usuarioService.getAllUsuario();
        model.addAttribute("titulo","Tabla Usuarios");
        model.addAttribute("usuarios",listarUsuario);
        return "usuarios";
    }
        
    @PostMapping("//usuario/update")
    public ModelAndView update(
        @RequestBody String payload,
        @RequestParam("id") String id,
        @RequestParam("username") String username,
        @RequestParam("password") String password, 
        @RequestParam("rol") String rol,
        @RequestParam("active") String active
    ){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("encodedPassword --> " + password + " = " + encodedPassword);
        
        // USERNAME, PASSWORD, ROL_ID, ACTIVE
        //this.jdbcTemplate.update("CALL sp_update_usuario(?, ?, 3, 1)", username, encodedPassword); 
        return new ModelAndView("/usuarios");
    }
}
