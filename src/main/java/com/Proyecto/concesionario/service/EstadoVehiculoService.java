package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.EstadoVehiculo;
import com.Proyecto.concesionario.repository.EstadoVehiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstadoVehiculoService implements IEstadoVehiculoService {
    
    @Autowired
    private EstadoVehiculoRepository estadoVehiculoRepository;
    
    @Override
    public List<EstadoVehiculo> getAll(){
        return (List<EstadoVehiculo>)estadoVehiculoRepository.findAll();
    }
}
