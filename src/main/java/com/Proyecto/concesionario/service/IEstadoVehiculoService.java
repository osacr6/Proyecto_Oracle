package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.EstadoVehiculo;
import java.util.List;

public interface IEstadoVehiculoService {

    public List<EstadoVehiculo> getAllEstadoVehiculo();

    public void saveEstadoVehiculo(String estado);

    public EstadoVehiculo getEstadoVehiculoById(long estado_id);

    public void deleteEstadoVehiculo(long estado_id);

    public void updateEstadoVehiculo(long estado_id, String estado);
}
