package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Carro;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface ICarroService {
    public List<Carro> getAllCarro();           //Lista de objetos de tipo carro 
    public Carro getCarroById (String id);
    public void UpdateCarro(String carro_id,long marca_id, long modelo_id, long estado_id 
            ,int kilometraje, int precio);         //Nueva fila en la tabla
    public void delete (long id);               //Eliminar fila dado un id        

   
}
