package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Carro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
 
@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
 
}
