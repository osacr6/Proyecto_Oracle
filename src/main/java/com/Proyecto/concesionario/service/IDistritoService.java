package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Distrito;
import java.util.List;

public interface IDistritoService {
    public List<Distrito> getAllDistrito();
    public void saveDistrito(Distrito distrito);
    public Distrito getDistritoById (long id);
    public void delete (long id);
}
