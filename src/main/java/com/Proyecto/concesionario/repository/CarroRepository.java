package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Carro;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//https://www.baeldung.com/spring-data-jpa-query

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query(value = "SELECT * FROM T_CARRO", nativeQuery = true)
    public List<Carro> findAll();

    @Query(value = "insert into T_CARRO (marca_id, modelo_id, trim_id,sucursal_id,estado_id,placa,color_interior,color_exterior,kilometraje,precio,vin)"
            + "values (:marca_id, :modelo_id, :trim_id,:sucursal_id,:estado_id,:placa,:color_interior,:color_exterior,:kilometraje,:precio,:vin)",
            nativeQuery = true)
    public Carro save(@Param("marca_id") long marca_id, @Param("modelo_id") long modelo_id,
            @Param("trim_id") long trim_id, @Param("sucursal_id") long sucursal_id, @Param("estado_id") long estado_id,
            @Param("placa") String placa, @Param("color_interior") int color_interior, @Param("color_exterior") int color_exterior,
            @Param("kilometraje") int kilometraje, @Param("precio") int precio, @Param("vin") String vin);

    @Query(value = "DELETE FROM T_CARRO WHERE CARRO_ID =:carro_id", nativeQuery = true)
    public Carro delete(@Param("carro_id") long carro_id);

    @Query(value = "update T_CARRO set marca_id=:marca_id, modelo_id=:modelo_id, trim_id=:trim_id,sucursal_id=:sucursal_id,estado_id=:estado_id,"
            + "placa=:placa,color_interior:color_interior,color_exterior=:color_exterior,kilometraje=:kilometraje,precio=:precio,vin=:vin"
            + " where carro_id = :carro_id", nativeQuery = true)
    public Carro update(@Param("carro_id") long carro_id, @Param("marca_id") long marca_id, @Param("modelo_id") long modelo_id,
            @Param("trim_id") long trim_id, @Param("sucursal_id") long sucursal_id, @Param("estado_id") long estado_id,
            @Param("placa") String placa, @Param("color_interior") int color_interior, @Param("color_exterior") int color_exterior,
            @Param("kilometraje") int kilometraje, @Param("precio") int precio, @Param("vin") String vin);

    @Query(value = "SELECT * FROM T_CARRO WHERE CARRO_ID = :carro_id", nativeQuery = true)
    public Carro findById(@Param("carro_id") long carro_id);
}
