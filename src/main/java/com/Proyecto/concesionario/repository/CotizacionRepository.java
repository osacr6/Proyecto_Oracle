package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Cotizacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionRepository extends CrudRepository<Cotizacion, Long> { 
}
