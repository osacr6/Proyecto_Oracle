package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Canton;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CantonRepository extends JpaRepository<Canton, Long> {

    @Query(value = "SELECT * FROM T_CANTON", nativeQuery = true)
    public List<Canton> findAll();

    @Modifying
    @Query(value = "INSERT INTO T_CANTON (canton) VALUES(:canton)", nativeQuery = true)
    @Transactional
    public void save(@Param("canton") String canton);

    @Modifying
    @Query(value = "DELETE FROM T_CANTON WHERE canton_id =:canton_id", nativeQuery = true)
    @Transactional
    public Canton delete(@Param("canton_id") long canton_id);

    @Modifying
    @Query(value = "update T_CANTON set canton=:canton where canton_id =:canton_id", nativeQuery = true)
    @Transactional
    public Canton update(@Param("canton_id") long canton_id, @Param("canton") String canton);

    @Query(value = "SELECT * FROM T_CANTON WHERE canton_id = :canton_id", nativeQuery = true)
    public Canton findById(@Param("canton_id") long canton_id);

}
