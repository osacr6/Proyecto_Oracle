package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Transmision;
import java.util.List;

public interface ITransmisionService {

    public List<Transmision> getAllTransmision();

    public void saveTransmision(String transmision);

    public Transmision getTransmisionById(long transmision_id);

    public void deleteTransmision(long transmision_id);

    public void updateTransmision(long transmision_id, String transmision);
}
