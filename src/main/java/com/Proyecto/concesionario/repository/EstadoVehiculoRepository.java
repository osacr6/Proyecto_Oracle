package com.Proyecto.concesionario.repository;


import com.Proyecto.concesionario.entity.EstadoVehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoVehiculoRepository extends CrudRepository<EstadoVehiculo, Long> {

    @Query(value = "SELECT * FROM T_ESTADO", nativeQuery = true)
    public List<EstadoVehiculo> findAll();
    
    @Query(value = "insert into T_ESTADO (estado) values (:estado)", nativeQuery = true)
    public EstadoVehiculo save(@Param("estado") String estado);

    @Query(value = "DELETE FROM T_ESTADO WHERE estado_id =:estado_id", nativeQuery = true)
    public EstadoVehiculo delete(@Param("estado_id") long estado_id);

    @Query(value = "update T_ESTADO set estado=:estado where estado_id =:estado_id", nativeQuery = true)
    public EstadoVehiculo update(@Param("estado_id") long estado_id, @Param("estado") String estado);

    @Query(value = "SELECT * FROM T_ESTADO WHERE estado_id = :estado_id", nativeQuery = true)
    public EstadoVehiculo findById(@Param("estado_id") long estado_id);
}
