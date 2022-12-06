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
      
    @Query(value = "insert into T_PROVINCIA (provincia) values (:provincia)", nativeQuery = true)
    public Provincia save(@Param("provincia") String marca);

    @Query(value = "DELETE FROM T_PROVINCIA WHERE provincia_id =:provincia_id", nativeQuery = true)
    public Provincia delete(@Param("provincia_id") long provincia_id);

    @Query(value = "update T_PROVINCIA set provincia=:provincia where provincia_id =:provincia_id", nativeQuery = true)
    public Provincia update(@Param("provincia_id") long provincia_id, @Param("provincia") String provincia);

    @Query(value = "SELECT * FROM T_PROVINCIA WHERE provincia_id = :provincia_id", nativeQuery = true)
    public Provincia findById(@Param("provincia_id") long provincia_id);
}
