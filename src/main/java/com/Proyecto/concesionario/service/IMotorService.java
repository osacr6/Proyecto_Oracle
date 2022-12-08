package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Motor;
import java.util.List;

public interface IMotorService {

    public List<Motor> getAllMotor();

    public void saveMotor(int cilindraje, long marca_id);

    public Motor getMotorById(long motor_id);

    public void deleteMotor(long motor_id);

    public void updateMotor(long motor_id, int cilindraje, long marca_id);
}
