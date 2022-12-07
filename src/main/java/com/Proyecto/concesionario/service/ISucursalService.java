package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Sucursal;
import java.util.List;

public interface ISucursalService {
    public List<Sucursal> getAllSucursal();
    public void saveSucursal(Sucursal sucursal);
    public Sucursal getSucursalById (long id);
    public void delete (long id);
}
