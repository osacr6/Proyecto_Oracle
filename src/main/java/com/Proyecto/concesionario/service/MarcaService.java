/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Marca;
import com.Proyecto.concesionario.repository.MarcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService implements IMarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    @Override
    public List<Marca> listMarcs(){
        return (List<Marca>)marcaRepository.findAll();}
}
