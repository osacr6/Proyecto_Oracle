package com.Proyecto.concesionario.repository;


import com.Proyecto.concesionario.entity.Banco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BancoRepository extends CrudRepository<Banco, Long>{
    
}
