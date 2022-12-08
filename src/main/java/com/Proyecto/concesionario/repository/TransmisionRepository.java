package com.Proyecto.concesionario.repository;


import com.Proyecto.concesionario.entity.Banco;
import com.Proyecto.concesionario.entity.Transmision;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransmisionRepository extends JpaRepository<Transmision, Long> {

    @Query(value = "SELECT * FROM T_TRANSMISION", nativeQuery = true)
    public List<Transmision> findAll();
    @Modifying
    @Query(value = "insert into T_TRANSMISION (transmision) values (:transmision)", nativeQuery = true)
    @Transactional
    public void save(@Param("transmision") String transmision);
    @Modifying
    @Query(value = "DELETE FROM T_TRANSMISION WHERE transmision_id =:transmision_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("transmision_id") long transmision_id);
    @Modifying
    @Query(value = "update T_TRANSMISION set transmision=:transmision where transmision_id =:transmision_id", nativeQuery = true)
    @Transactional
    public void update(@Param("transmision_id") long transmision_id, @Param("transmision") String transmision);

    @Query(value = "SELECT * FROM T_TRANSMISION WHERE transmision_id = :transmision_id", nativeQuery = true)
    public Transmision findById(@Param("transmision_id") long transmision_id);

}
