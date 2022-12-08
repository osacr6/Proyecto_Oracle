package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Modelo;
import java.util.List;

public interface IModeloService {

    public List<Modelo> getAllModelo();

    public void saveModelo(String detalles);

    public Modelo getModeloById(long id);

    public void deleteModelo(long id);

    public void updateModelo(long modelo_id, String ubicacion);
}
