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
    public List<Provincia> getAllProvincia(){
        return (List<Provincia>)provinciaRepository.findAll();
    }

    @Override
    public void saveProvincia(String provincia) {
         provinciaRepository.save(provincia);
    }

    @Override
    public Provincia getProvinciaById(long id) {
        return provinciaRepository.findById(id);
    }

    @Override
    public void delete(long id) {
          provinciaRepository.deleteById(id);
    }

    @Override
    public void update(long provincia_id, String provincia) {
        provinciaRepository.update(provincia_id, provincia);
    }
}
