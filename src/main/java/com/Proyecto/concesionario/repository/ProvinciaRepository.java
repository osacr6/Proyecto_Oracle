package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    @Query(value = "SELECT * FROM T_PROVINCIA", nativeQuery = true)
    public List<Provincia> findAll();

    @Modifying
    @Query(value = "CALL sp_crear_provincia(:provincia)", nativeQuery = true)
    @Transactional
    public void insert(@Param("provincia") String provincia);

    @Modifying
    @Query(value = "DELETE FROM T_PROVINCIA WHERE provincia_id =:provincia_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("provincia_id") long provincia_id);

    @Modifying
    @Query(value = "UPDATE T_PROVINCIA SET provincia=:provincia where provincia_id =:provincia_id", nativeQuery = true)
    @Transactional
    public void update(@Param("provincia_id") long provincia_id, @Param("provincia") String provincia);

    @Query(value = "SELECT * FROM T_PROVINCIA WHERE provincia_id = :provincia_id", nativeQuery = true)
    public Provincia findById(@Param("provincia_id") long provincia_id);
}
