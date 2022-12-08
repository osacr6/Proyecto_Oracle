package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Carro;
import com.Proyecto.concesionario.repository.CarroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;


@Service
public class CarroService implements ICarroService{
    
    @Autowired                                
    private CarroRepository carroRepository;

    @Override
    public List<Carro> getAllCarro() {
      return (List<Carro>)carroRepository.findAll();            
    }   

    @Override
    public Carro getCarroById(long id) {
       return carroRepository.findById(id);
    }

    @Override
    public void delete(long id) {
       carroRepository.delete(id);
    }

    @Override
    public void UpdateCarro(long carro_id, long marca_id, long modelo_id, long trim_id, 
            long sucursal_id, long estado_id, String placa, int color_interior, int color_exterior, int kilometraje, int precio, String vin) {
        carroRepository.update(carro_id, marca_id, modelo_id, trim_id, sucursal_id, estado_id, placa, color_interior, color_exterior, kilometraje, precio, vin);
    }

    @Override
    public void save(long marca_id, long modelo_id, long trim_id, long sucursal_id,
            long estado_id, String placa, int color_interior, int color_exterior, int kilometraje, int precio, String vin) {
        carroRepository.save(marca_id, modelo_id, trim_id, sucursal_id, estado_id, placa, color_interior, color_exterior, kilometraje, precio, vin);
    }

}