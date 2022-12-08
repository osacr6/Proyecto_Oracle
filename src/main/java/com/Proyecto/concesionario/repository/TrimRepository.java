package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Banco;
import com.Proyecto.concesionario.entity.Trim;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TrimRepository extends JpaRepository<Trim, Long> {

    @Query(value = "SELECT * FROM T_TRIM", nativeQuery = true)
    public List<Trim> findAll();

    @Modifying
    @Query(value = "insert into T_TRIM (codigo, motor_id,transmision_id,numero_puertas) values (:codigo,:motor_id,:transmision_id,:numero_puertas)",
            nativeQuery = true)
    @Transactional
    public void save(@Param("codigo") String codigo, @Param("motor_id") long motor_id,
            @Param("transmision_id") long transmision_id, @Param("numero_puertas") int numero_puertas);

    @Modifying
    @Query(value = "DELETE FROM T_TRIM WHERE trim_id =:trim_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("trim_id") long trim_id);

    @Modifying
    @Query(value = "update T_TRIM set codigo=:codigo, motor_id=:motor_id, transmision_id:transmision_id , numero_puertas=:numero_puertas"
            + "where trim_id =:trim_id", nativeQuery = true)
    @Transactional
    public void update(@Param("trim_id") long trim_id, @Param("codigo") String codigo, @Param("motor_id") long motor_id,
            @Param("transmision_id") long transmision_id, @Param("numero_puertas") int numero_puertas);

    @Query(value = "SELECT * FROM T_TRIM WHERE trim_id = :trim_id", nativeQuery = true)
    public Trim findById(@Param("trim_id") long trim_id);

}
