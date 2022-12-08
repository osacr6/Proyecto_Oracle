package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Distrito;
import java.util.List;

public interface IDistritoService {
    public List<Distrito> getAllDistrito();
    public void saveDistrito(String distrito);
    public Distrito getDistritoById (long id);
    public void delete (long id);
    public void update(long distrito_id, String distrito);
}
