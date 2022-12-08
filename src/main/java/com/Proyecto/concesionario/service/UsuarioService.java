package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Usuario;
import com.Proyecto.concesionario.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuario() {
       return (List<Usuario>)usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }
    
    @Override
    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
}
