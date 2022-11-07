package com.Proyecto.concesionario.service;


import com.Proyecto.concesionario.entity.Banco;
import com.Proyecto.concesionario.repository.BancoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BancoService implements IBancoService{
    @Autowired
    private BancoRepository localRepository;
    
    @Override
    public List<Banco> listLocal(){
        return (List<Banco>)localRepository.findAll();}
}
