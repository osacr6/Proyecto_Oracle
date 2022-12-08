package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Marca;
import com.Proyecto.concesionario.repository.MarcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService implements IMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> getAllMarca() {
        return (List<Marca>) marcaRepository.findAll();
    }

    @Override
    public void saveMarca(String marca) {
        marcaRepository.save(marca);
    }

    @Override
    public Marca getMarcaById(long marca_id) {
        return marcaRepository.findById(marca_id);
    }

    @Override
    public void deleteMarca(long marca_id) {
        marcaRepository.delete(marca_id);
    }

    @Override
    public void updateMarca(long marca_id, String marca) {
        marcaRepository.update(marca_id, marca);
    }

}
