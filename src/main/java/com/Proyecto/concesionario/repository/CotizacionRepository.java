package com.Proyecto.concesionario.repository;

import com.Proyecto.concesionario.entity.Banco;
import com.Proyecto.concesionario.entity.Cotizacion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionRepository extends CrudRepository<Cotizacion, Long> {

    @Query(value = "SELECT * FROM T_COTIZACION", nativeQuery = true)
    public List<Cotizacion> findAll();

    @Query(value = "insert into T_COTIZACION (factura_id, banco_id,prima) values (:factura_id,:banco_id,:prima)", nativeQuery = true)
    public Cotizacion save(@Param("factura_id") long factura_id, @Param("banco_id") long banco_id, @Param("prima") long prima);

    @Query(value = "DELETE FROM T_COTIZACION WHERE cotizacion_id =:cotizacion_id", nativeQuery = true)
    public Cotizacion delete(@Param("cotizacion_id") long banco_id);

    @Query(value = "update T_COTIZACION set factura_id=:factura_id, banco_id=:banco_id,prima=:prima where cotizacion_id =:cotizacion_id", nativeQuery = true)
    public Cotizacion update(@Param("cotizacion_id") long cotizacion_id,
             @Param("factura_id") long factura_id, @Param("banco_id") long banco_id, @Param("prima") long prima);

    @Query(value = "SELECT * FROM T_COTIZACION WHERE cotizacion_id = :cotizacion_id", nativeQuery = true)
    public Cotizacion findById(@Param("cotizacion_id") long banco_id);
}
