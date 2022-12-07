package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Provincia;
import java.util.List;

public interface IProvinciaService {
    public List<Provincia> getAllProvincia();
    public void saveProvincia(String provincia);
    public Provincia getProvinciaById (long id);
    public void delete (long id);
    public void update(long provincia_id, String provincia);
}
