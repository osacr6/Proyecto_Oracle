package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Marca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long> { 
}
