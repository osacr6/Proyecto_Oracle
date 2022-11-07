package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.EstadoVehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoVehiculoRepository extends CrudRepository<EstadoVehiculo, Long> { 
}
