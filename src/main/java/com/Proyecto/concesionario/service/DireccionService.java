package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Direccion;
import com.Proyecto.concesionario.repository.DireccionRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService implements IDireccionService {
    
    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public List<Direccion> getAllDireccion() {
       return (List<Direccion>)direccionRepository.findAll();
    }

    @Override
    public Direccion getDireccionById(long id) {
        return direccionRepository.findById(id);
    }

    @Override
    public void saveDireccion(Direccion direccion) {
        direccionRepository.save(direccion);
    }

    @Override
    public void delete(long id) {
        direccionRepository.deleteById(id);
    }

}
