package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// https://github.com/bezkoder/spring-jpa-native-query-example

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    
    @Query(value = "SELECT * FROM T_USUARIO WHERE username = 'Daniel'", nativeQuery = true)
    public List<Usuario> findByUsername(@Param("user_name") String username);
}
