package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.EstadoVehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EstadoVehiculoRepository extends JpaRepository<EstadoVehiculo, Long> {

    @Query(value = "SELECT * FROM T_ESTADO", nativeQuery = true)
    public List<EstadoVehiculo> findAll();

    @Modifying
    @Query(value = "insert into T_ESTADO (estado) values (:estado)", nativeQuery = true)
    @Transactional
    public void save(@Param("estado") String estado);

    @Modifying
    @Query(value = "DELETE FROM T_ESTADO WHERE estado_id =:estado_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("estado_id") long estado_id);

    @Modifying
    @Query(value = "update T_ESTADO set estado=:estado where estado_id =:estado_id", nativeQuery = true)
    @Transactional
    public void update(@Param("estado_id") long estado_id, @Param("estado") String estado);

    @Query(value = "SELECT * FROM T_ESTADO WHERE estado_id = :estado_id", nativeQuery = true)
    public EstadoVehiculo findById(@Param("estado_id") long estado_id);
}
