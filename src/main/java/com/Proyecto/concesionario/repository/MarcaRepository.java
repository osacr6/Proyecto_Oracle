package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Marca;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long> { 
    @Query(value = "SELECT * FROM T_MARCA", nativeQuery = true)
    public List<Marca> findAll();
    
    @Query(value = "insert into T_MARCA (marca) values (:marca)", nativeQuery = true)
    public Marca save(@Param("marca") String marca);

    @Query(value = "DELETE FROM T_MARCA WHERE marca_id =:marca_id", nativeQuery = true)
    public Marca delete(@Param("marca_id") long marca_id);

    @Query(value = "update T_MARCA set marca=:marca where marca_id =:marca_id", nativeQuery = true)
    public Marca update(@Param("marca_id") long marca_id, @Param("marca") String marca);

    @Query(value = "SELECT * FROM T_MARCA WHERE marca_id = :marca_id", nativeQuery = true)
    public Marca findById(@Param("marca_id") long marca_id);
}
