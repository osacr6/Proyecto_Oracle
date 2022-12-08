package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Direccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

    @Query(value = "SELECT * FROM T_DIRECCION", nativeQuery = true)
    public List<Direccion> findAll();

    @Modifying
    @Query(value = "insert into T_DIRECCION (provincia_id, canton_id,distrito_id,detalles,ubicacion) "
            + "values (:provincia_id,:canton_id,:distrito_id,:detalles,:ubicacion)", nativeQuery = true)
    @Transactional
    public void save(
            @Param("provincia_id") long provincia_id,
            @Param("canton_id") long canton_id,
            @Param("distrito_id") long distrito_id,
            @Param("detalles") String detalles,
            @Param("ubicacion") String ubicacion
    );

    @Modifying
    @Query(value = "DELETE FROM T_DIRECCION WHERE direccion_id =:direccion_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("direccion_id") long direccion_id);

    @Modifying
    @Query(value = "update T_DIRECCION set provincia_id=:provincia_id, canton_id=:canton_id, distrito_id=:distrito_id, detalles=:detalles, "
            + "ubicacion=:ubicacion where direccion_id =:direccion_id", nativeQuery = true)
    @Transactional
    public void update(
            @Param("direccion_id") long direccion_id,
            @Param("provincia_id") long provincia_id,
            @Param("canton_id") long canton_id,
            @Param("distrito_id") long distrito_id,
            @Param("detalles") String detalles,
            @Param("ubicacion") String ubicacion
    );

    @Modifying
    @Query(value = "SELECT * FROM T_DIRECCION WHERE direccion_id = :direccion_id", nativeQuery = true)
    public Direccion findById(@Param("direccion_id") long direccion_id);

}
