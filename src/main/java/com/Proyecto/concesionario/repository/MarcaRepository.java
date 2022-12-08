package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Marca;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    @Query(value = "SELECT * FROM T_MARCA", nativeQuery = true)
    public List<Marca> findAll();

    @Modifying
    @Query(value = "insert into T_MARCA (marca) values (:marca)", nativeQuery = true)
    @Transactional
    public void save(@Param("marca") String marca);

    @Modifying
    @Query(value = "DELETE FROM T_MARCA WHERE marca_id =:marca_id", nativeQuery = true)
    @Transactional
    public void delete(@Param("marca_id") long marca_id);

    @Modifying
    @Query(value = "update T_MARCA set marca=:marca where marca_id =:marca_id", nativeQuery = true)
    @Transactional
    public void update(@Param("marca_id") long marca_id, @Param("marca") String marca);

    @Query(value = "SELECT * FROM T_MARCA WHERE marca_id = :marca_id", nativeQuery = true)
    public Marca findById(@Param("marca_id") long marca_id);
}
