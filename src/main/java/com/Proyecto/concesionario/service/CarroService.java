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
    
    @Autowired                                //dependencias
    private CarroRepository carroRepository;

    @Override
    public List<Carro> getAllCarro() {
      return (List<Carro>)carroRepository.findAll();             //Devuelve toda la lista de carros
    }   

    @Override
    public Carro getCarroById(long id) {
       return carroRepository.findById(id);
    }

    @Override
    public void UpdateCarro(long carro_id,long marca_id, long modelo_id, 
            long estado_id, int kilometraje, int precio
    ) {
        carroRepository.update(carro_id,marca_id,modelo_id,estado_id,kilometraje,precio);
    }

    @Override
    public void delete(long id) {
       carroRepository.delete(id);
    }
  
  /*      
    public void uploadImageCarro(MultipartFile file) throws IllegalStateException, IOException{
        //file.transferTo(new File("\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename()));
    }
*/

}