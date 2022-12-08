package com.Proyecto.concesionario.service;


import com.Proyecto.concesionario.entity.Direccion;
import java.util.List;

public interface IDireccionService {
    public List<Direccion> getAllDireccion();
    public void saveDireccion(long provincia_id, long canton_id, long distrito_id, String detalles, String ubicacion);
    public Direccion getDireccionById (long id);
    public void delete (long id);
    public void update(long direccion_id, long provincia_id, long canton_id, long distrito_id, String detalles, String ubicacion);
}
