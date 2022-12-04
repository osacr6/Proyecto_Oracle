package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> getAllUsuario();
    public void saveUsuario(Usuario usuario);
    public Usuario getUsuarioById (long id);
    public void delete (long id);
    public Usuario findByUsername (String username);
}
