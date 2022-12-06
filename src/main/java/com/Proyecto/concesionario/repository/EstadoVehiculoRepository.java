package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.EstadoVehiculo;
import com.Proyecto.concesionario.entity.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoVehiculoRepository extends CrudRepository<EstadoVehiculo, Long> { 
        @Query(value = "SELECT * FROM T_ESTADO", nativeQuery = true)
    public List<EstadoVehiculo> findAll();
}
