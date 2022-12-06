package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Marca;
import com.Proyecto.concesionario.entity.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long> { 
        @Query(value = "SELECT * FROM T_MARCA", nativeQuery = true)
    public List<Marca> findAll();
}
