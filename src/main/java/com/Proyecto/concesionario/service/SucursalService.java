package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Sucursal;
import com.Proyecto.concesionario.entity.Usuario;
import com.Proyecto.concesionario.repository.SucursalRepository;
import com.Proyecto.concesionario.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService implements ISucursalService {
    
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> getAllSucursal() {
       return (List<Sucursal>)sucursalRepository.findAll();
    }

    @Override
    public Sucursal getSucursalById(long id) {
        return sucursalRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public void saveSucursal(long direccion_id, int numero, String nombre, String telefono) {
        sucursalRepository.save(direccion_id, numero, nombre, telefono);
    }

    @Override
    public void update(long sucursal_id, long direccion_id, int numero, String nombre, String telefono) {
        sucursalRepository.update(sucursal_id, direccion_id, numero, nombre, telefono);
    }

}
