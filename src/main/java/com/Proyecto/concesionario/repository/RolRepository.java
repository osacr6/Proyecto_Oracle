/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
    @Query(value = "SELECT * FROM T_ROL", nativeQuery = true)
    public List<Rol> findAll();
    
    @Query(value = "SELECT * FROM T_ROL R WHERE r.rol_id = :id", nativeQuery = true)
    public Rol findById(@Param("id") String id);
}
