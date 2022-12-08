package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Trim;
import java.util.List;

public interface ITrimService {

    public List<Trim> getAllTrim();

    public void saveTrim(String codigo, long motor_id, long transmision_id, int numero_puertas);

    public Trim getTrimById(long trim_id);

    public void deleteTrim(long trim_id);

    public void updateTrim(long trim_id, String codigo, long motor_id, long transmision_id, int numero_puertas);
}
