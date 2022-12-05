package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.Carro;
import com.Proyecto.concesionario.service.ICarroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {   
    
    @Autowired
    private ICarroService carroService;
    
    @GetMapping("/")
    public String index(Model model) { 
        List<Carro> listaCarro = carroService.getAllCarro();        
        model.addAttribute("carros", listaCarro);
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) { 
        List<Carro> listaCarro = carroService.getAllCarro();        
        model.addAttribute("carros", listaCarro);
        return "home";
    }

}
    

