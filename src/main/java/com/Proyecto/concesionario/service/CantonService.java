package com.Proyecto.concesionario.service;


import com.Proyecto.concesionario.entity.Canton;
import com.Proyecto.concesionario.repository.CantonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CantonService implements ICantonService {
    
    @Autowired
    private CantonRepository cantonRepository;

    @Override
    public List<Canton> getAllCanton() {
       return (List<Canton>)cantonRepository.findAll();
    }

    @Override
    public Canton getCantonById(long id) {
        return cantonRepository.findById(id);
    }

    @Override
    public void saveCanton(Canton canton) {
        cantonRepository.save(canton);
    }

    @Override
    public void delete(long id) {
        cantonRepository.deleteById(id);
    }
    
}
