package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Transmision;
import com.Proyecto.concesionario.repository.TransmisionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransmisionService implements ITransmisionService {
    
    @Autowired
    private TransmisionRepository transmisionRepository;
    
    @Override
    public List<Transmision> getAllTransmision() {
        return (List<Transmision>) transmisionRepository.findAll();
    }
    
    @Override
    public void saveTransmision(String transmision) {
        transmisionRepository.save(transmision);
    }
    
    @Override
    public Transmision getTransmisionById(long transmision_id) {
        return transmisionRepository.findById(transmision_id);
    }
    
    @Override
    public void deleteTransmision(long transmision_id) {
        transmisionRepository.delete(transmision_id);
        
    }
    
    @Override
    public void updateTransmision(long transmision_id, String transmision) {
        transmisionRepository.update(transmision_id, transmision);
        
    }
    
}
