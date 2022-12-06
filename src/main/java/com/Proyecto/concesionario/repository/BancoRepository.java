package com.Proyecto.concesionario.repository;


import com.Proyecto.concesionario.entity.Banco;
import com.Proyecto.concesionario.entity.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BancoRepository extends CrudRepository<Banco, Long>{
        @Query(value = "SELECT * FROM T_BANCO", nativeQuery = true)
    public List<Banco> findAll();
    
}
