package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Usuario;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// https://github.com/bezkoder/spring-jpa-native-query-example

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    @Query(value = "SELECT * FROM T_USUARIO WHERE username = :username", nativeQuery = true)
    public Usuario findByUsername(@Param("username") String username);
}
