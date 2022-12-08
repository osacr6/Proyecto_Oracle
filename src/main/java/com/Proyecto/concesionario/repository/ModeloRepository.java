package com.Proyecto.concesionario.repository;


import com.Proyecto.concesionario.entity.Modelo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    @Query(value = "SELECT * FROM T_MODELO", nativeQuery = true)
    public List<Modelo> findAll();
    
    @Modifying
    @Query(value = "insert into T_MODELO (modelo) values (:modelo)", nativeQuery = true)
    @Transactional
    public void save(@Param("modelo") String modelo);
    @Modifying
    @Query(value = "DELETE FROM T_MODELO WHERE modelo_id =:modelo_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("modelo_id") long modelo_id);
    @Modifying
    @Query(value = "update T_MODELO set modelo=:modelo where modelo_id =:modelo_id", nativeQuery = true)
    @Transactional
    public void update(@Param("modelo_id") long modelo_id, @Param("modelo") String modelo);

    @Query(value = "SELECT * FROM T_MODELO WHERE banco_id = :modelo_id", nativeQuery = true)
    public Modelo findById(@Param("modelo_id") long modelo_id);

}
