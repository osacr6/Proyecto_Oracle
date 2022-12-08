package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Marca;
import java.util.List;

public interface IMarcaService {

    public List<Marca> getAllMarca();

    public void saveMarca(String marca);

    public Marca getMarcaById(long marca_id);

    public void deleteMarca(long marca_id);

    public void updateMarca(long marca_id, String marca);
}
