package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends CrudRepository<Provincia, Long> { 
    @Query(value = "SELECT * FROM T_PROVINCIA", nativeQuery = true)
    public List<Provincia> findAll();
}
