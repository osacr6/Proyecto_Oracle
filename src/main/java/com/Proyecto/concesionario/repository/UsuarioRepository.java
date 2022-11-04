package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    Usuario findByNombre (String nombre);
}
