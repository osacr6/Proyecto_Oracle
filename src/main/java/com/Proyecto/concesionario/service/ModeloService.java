package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Modelo;
import com.Proyecto.concesionario.repository.ModeloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService implements IModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public List<Modelo> getAllModelo() {
        return (List<Modelo>) modeloRepository.findAll();
    }

    @Override
    public void saveModelo(String modelo) {
        modeloRepository.save(modelo);
    }

    @Override
    public Modelo getModeloById(long modelo_id) {
        return modeloRepository.findById(modelo_id);
    }

    @Override
    public void deleteModelo(long modelo_id) {
        modeloRepository.delete(modelo_id);
    }

    @Override
    public void updateModelo(long modelo_id, String modelo) {
        modeloRepository.update(modelo_id, modelo);
    }

}
