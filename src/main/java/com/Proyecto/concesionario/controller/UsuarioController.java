package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.Usuario;
import com.Proyecto.concesionario.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/usuario") 
        public String index (Model model){
        List <Usuario> listarUsuario = usuarioService.getAllUsuario();
        model.addAttribute("titulo","Tabla Usuarios");
        model.addAttribute("usuarios",listarUsuario);
        return "usuarios";
    }
}
