package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Provincia;
import com.Proyecto.concesionario.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService implements IProvinciaService {
    
    @Autowired
    private ProvinciaRepository provinciaRepository;
    
    @Override
    public List<Provincia> getAll(){
        return (List<Provincia>)provinciaRepository.findAll();
    }
}
