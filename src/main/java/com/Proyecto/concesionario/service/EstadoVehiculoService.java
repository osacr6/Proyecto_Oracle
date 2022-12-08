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
    public List<EstadoVehiculo> getAllEstadoVehiculo() {
         return (List<EstadoVehiculo>)estadoVehiculoRepository.findAll();
    }

    @Override
    public void saveEstadoVehiculo(String estado) {
        estadoVehiculoRepository.save(estado);
    }

    @Override
    public EstadoVehiculo getEstadoVehiculoById(long estado_id) {
        return estadoVehiculoRepository.findById(estado_id);
    }

    @Override
    public void deleteEstadoVehiculo(long estado_id) {
        estadoVehiculoRepository.delete(estado_id);
    }

    @Override
    public void updateEstadoVehiculo(long estado_id, String estado) {
        estadoVehiculoRepository.update(estado_id, estado);
    }

}
