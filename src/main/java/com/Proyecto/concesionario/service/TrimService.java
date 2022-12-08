package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Trim;
import com.Proyecto.concesionario.repository.TrimRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrimService implements ITrimService {

    @Autowired
    private TrimRepository trimRepository;

    @Override
    public List<Trim> getAllTrim() {
        return (List<Trim>) trimRepository.findAll();
    }

    @Override
    public void saveTrim(String codigo, long motor_id, long transmision_id, int numero_puertas) {
        trimRepository.save(codigo, motor_id, transmision_id, numero_puertas);
    }

    @Override
    public Trim getTrimById(long trim_id) {
        return trimRepository.findById(trim_id);

    }

    @Override
    public void deleteTrim(long trim_id) {
        trimRepository.delete(trim_id);
    }

    @Override
    public void updateTrim(long trim_id, String codigo, long motor_id, long transmision_id, int numero_puertas) {
        trimRepository.update(trim_id, codigo, motor_id, transmision_id, numero_puertas);
    }

}
