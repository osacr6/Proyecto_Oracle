package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    @Query(value = "SELECT * FROM T_SUCURSAL", nativeQuery = true)
    public List<Sucursal> findAll();

    @Modifying
    @Query(value = "insert into T_SUCURSAL (direccion_id, numero,nombre,telefono) values (:direccion_id,:numero,:nombre,:telefono)", nativeQuery = true)
    @Transactional
    public void save(@Param("direccion_id") long direccion_id, @Param("numero") int numero, @Param("nombre") String nombre,
            @Param("telefono") String telefono);

    @Modifying
    @Query(value = "DELETE FROM T_SUCURSAL WHERE sucursal_id =:sucursal_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("sucursal_id") long sucursal_id);

    @Modifying
    @Query(value = "update T_SUCURSAL set direccion_id=:direccion_id, numero=:numero,nombre=:nombre, telefono=:telefono where sucursal_id =:sucursal_id", nativeQuery = true)
    @Transactional
    public void update(@Param("sucursal_id") long sucursal_id,
            @Param("direccion_id") long direccion_id, @Param("numero") int numero, @Param("nombre") String nombre, @Param("telefono") String telefono);

    @Query(value = "SELECT * FROM T_SUCURSAL WHERE sucursal_id = :sucursal_id", nativeQuery = true)
    public Sucursal findById(@Param("sucursal_id") long sucursal_id);

}
