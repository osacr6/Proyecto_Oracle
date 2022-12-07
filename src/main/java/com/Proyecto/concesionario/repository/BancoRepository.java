package com.Proyecto.concesionario.repository;


import com.Proyecto.concesionario.entity.Banco;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {

    @Query(value = "SELECT * FROM T_BANCO", nativeQuery = true)
    public List<Banco> findAll();

    @Query(value = "insert into T_BANCO (banco, tasa) values (:banco,:tasa)", nativeQuery = true)
    public Banco save(@Param("banco") String banco, @Param("tasa") float tasa);

    @Query(value = "DELETE FROM T_BANCO WHERE banco_id =:banco_id", nativeQuery = true)
    public Banco delete(@Param("banco_id") long banco_id);

    @Query(value = "update T_BANCO set banco=:banco, tasa=:tasa where banco_id =:banco_id", nativeQuery = true)
    public Banco update(@Param("banco_id") long banco_id, @Param("banco") String banco, @Param("tasa") float tasa);

    @Query(value = "SELECT * FROM T_BANCO WHERE banco_id = :banco_id", nativeQuery = true)
    public Banco findById(@Param("banco_id") long banco_id);

}
