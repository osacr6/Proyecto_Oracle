package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Distrito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long> {

    @Query(value = "SELECT * FROM T_DISTRITO", nativeQuery = true)
    public List<Distrito> findAll();

    @Modifying
    @Query(value = "insert into T_DISTRITO (distrito) values (:distrito)", nativeQuery = true)
    @Transactional
    public void save(@Param("distrito") String distrito);

    @Modifying
    @Query(value = "DELETE FROM T_DISTRITO WHERE distrito_id =:distrito_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("distrito_id") long distrito_id);

    @Modifying
    @Query(value = "update T_DISTRITO set distrito=:distrito where distrito_id =:distrito_id", nativeQuery = true)
    @Transactional
    public void update(@Param("distrito_id") long distrito_id, @Param("distrito") String distrito);

    @Query(value = "SELECT * FROM T_DISTRITO WHERE distrito_id = :distrito_id", nativeQuery = true)
    public Distrito findById(@Param("distrito_id") long distrito_id);

}
