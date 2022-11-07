package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Cotizacion;
import com.Proyecto.concesionario.repository.CotizacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CotizacionService implements ICotizacionService {
    
    @Autowired
    private CotizacionRepository cotizacionRepository;
    
    @Override
    public List<Cotizacion> getCotizaciones(){
        return (List<Cotizacion>)cotizacionRepository.findAll();
    }   
    
    @Override
    public int saveCotizacion(Cotizacion cotizacion) {
        int res = 0;                
        Cotizacion c = cotizacionRepository.save(cotizacion);        
        if(!c.equals(null)){
            res = 1;
        }                                          
        return res;
    }
    
    @Override
    public void delete(long id) {
       cotizacionRepository.deleteById(id);
    }
}
