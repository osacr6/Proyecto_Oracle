package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.Rol;
import com.Proyecto.concesionario.entity.Usuario;
import com.Proyecto.concesionario.repository.RolRepository;
import com.Proyecto.concesionario.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/usuarios") 
    public String index (Model model){
        List<Usuario> listaUsuario = usuarioService.getAllUsuario();
        List<Rol> listaRoles = rolRepository.findAll();
        
        model.addAttribute("titulo","Tabla Usuarios");
        model.addAttribute("usuarios",listaUsuario);
        model.addAttribute("roles",listaRoles);
        return "usuarios";
    }
    
    @PostMapping("/usuario/create")
    public String create(
        @RequestBody String payload,
        @RequestParam("username") String username,
        @RequestParam("password") String password, 
        @RequestParam("rol") String rol,
        @RequestParam("active") String active
    ){
        String encodedPassword = null;
        

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        encodedPassword = passwordEncoder.encode(password);
        System.out.println("encodedPassword --> " + password + " = " + encodedPassword);
        
        // ID, USERNAME, PASSWORD, ROL_ID, ACTIVE
        this.jdbcTemplate.update(
            "CALL sp_crear_usuario(?, ?, ?, ?)",
            username, 
            encodedPassword,
            rol,
            active
        );
 
        return "redirect:/usuarios";
    }
        
    @PostMapping("/usuario/update")
    public String update(
        @RequestBody String payload,
        @RequestParam("id") String id,
        @RequestParam("username") String username,
        @RequestParam("password") String password, 
        @RequestParam("rol") String rol,
        @RequestParam("active") String active
    ){
        //getUsuarioById
        Usuario usuario = usuarioService.getUsuarioById(id);
        String encodedPassword = null;
        
        if( password.length() == 0 ) {
            encodedPassword = usuario.getPassword();
            System.out.println("encodedPassword --> " + encodedPassword);
        } else {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            encodedPassword = passwordEncoder.encode(password);
            System.out.println("encodedPassword --> " + password + " = " + encodedPassword);
        }
        
        // ID, USERNAME, PASSWORD, ROL_ID, ACTIVE
        this.jdbcTemplate.update(
            "CALL sp_update_usuario(?, ?, ?, ?, ?)",
            id,
            username, 
            encodedPassword,
            rol,
            active
        );
 
        return "redirect:/usuarios";
    }
    
    @GetMapping("/usuario/delete/{id}") 
    public String delete (@PathVariable("id") Long id){

        this.jdbcTemplate.update(
            "CALL sp_delete_usuario(?)",
            id
        );
 
        return "redirect:/usuarios";
    }
}
