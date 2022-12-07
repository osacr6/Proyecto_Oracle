package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Sucursal;
import java.util.List;

public interface ISucursalService {
    public List<Sucursal> getAllSucursal();
    public void saveSucursal(long direccion_id, int numero, String nombre, String telefono);
    public Sucursal getSucursalById (long id);
    public void delete (long id);
    public void update(long sucursal_id, long direccion_id, int numero, String nombre, String telefono);
}
