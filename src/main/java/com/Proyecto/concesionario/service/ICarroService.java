package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Carro;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface ICarroService {

    public List<Carro> getAllCarro();

    public Carro getCarroById(long id);

    public void UpdateCarro(long carro_id, long marca_id, long modelo_id, long trim_id, long sucursal_id, long estado_id, String placa,
            int color_interior, int color_exterior, int kilometraje, int precio, String vin);

    public void delete(long id);

    public void save(long marca_id, long modelo_id, long trim_id, long sucursal_id, long estado_id, String placa,
            int color_interior, int color_exterior, int kilometraje, int precio, String vin);

}
