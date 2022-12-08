package com.Proyecto.concesionario.repository;


import com.Proyecto.concesionario.entity.Motor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Long> {

    @Query(value = "SELECT * FROM T_MOTOR", nativeQuery = true)
    public List<Motor> findAll();
    @Modifying
    @Query(value = "insert into T_MOTOR (cilindraje, marca_id) values (:cilindraje,:marca_id)", nativeQuery = true)
    @Transactional
    public void save(@Param("cilindraje") int cilindraje, @Param("marca_id") long marca_id);
    @Modifying
    @Query(value = "DELETE FROM T_MOTOR WHERE motor_id =:motor_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("motor_id") long motor_id);
    @Modifying
    @Query(value = "update T_MOTOR set cilindraje=:cilindraje, marca_id=:marca_id where motor_id =:motor_id", nativeQuery = true)
    @Transactional
    public void update(@Param("motor_id") long motor_id, @Param("cilindraje") int cilindraje, @Param("marca_id") long marca_id);

    @Query(value = "SELECT * FROM T_MOTOR WHERE banco_id = :motor_id", nativeQuery = true)
    public Motor findById(@Param("motor_id") long motor_id);

}
