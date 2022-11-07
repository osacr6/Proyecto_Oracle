package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Cotizacion;
import java.util.List;

public interface ICotizacionService {
    public List<Cotizacion> getCotizaciones();  
    public int saveCotizacion(Cotizacion cotizacion);
    public void delete(long id);
}
