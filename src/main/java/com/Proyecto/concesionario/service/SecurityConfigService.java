package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Carro;
import com.Proyecto.concesionario.entity.Usuario;
import com.Proyecto.concesionario.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityConfigService implements UserDetailsService {           //userservice: se guarda la info para despues ser utilizada
    //Interactua con spring security 

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  //Cargando la info del username
        Usuario usuario = usuarioRepository.findByUsername(username);      
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }   
        return usuario;
    }
}
