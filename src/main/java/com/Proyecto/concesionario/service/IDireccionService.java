package com.Proyecto.concesionario.service;


import com.Proyecto.concesionario.entity.Direccion;
import java.util.List;

public interface IDireccionService {
    public List<Direccion> getAllDireccion();
    public void saveDireccion(Direccion direccion);
    public Direccion getDireccionById (long id);
    public void delete (long id);
}
