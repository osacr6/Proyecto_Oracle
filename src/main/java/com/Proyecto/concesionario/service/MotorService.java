package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Motor;
import com.Proyecto.concesionario.repository.MotorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorService implements IMotorService {
    
    @Autowired
    private MotorRepository motorRepository;
    
    @Override
    public List<Motor> getAllMotor() {
        return (List<Motor>) motorRepository.findAll();
    }
    
    @Override
    public void saveMotor(int cilindraje, long marca_id) {
        motorRepository.save(cilindraje, marca_id);
    }
    
    @Override
    public Motor getMotorById(long motor_id) {
        return motorRepository.findById(motor_id);
    }
    
    @Override
    public void deleteMotor(long motor_id) {
        motorRepository.delete(motor_id);
    }
    
    @Override
    public void updateMotor(long motor_id, int cilindraje, long marca_id) {
        motorRepository.update(motor_id, cilindraje, marca_id);
        
    }
    
}
