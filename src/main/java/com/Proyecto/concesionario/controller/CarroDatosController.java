/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.EstadoVehiculo;
import com.Proyecto.concesionario.entity.Marca;
import com.Proyecto.concesionario.entity.Modelo;
import com.Proyecto.concesionario.entity.Motor;
import com.Proyecto.concesionario.entity.Transmision;
import com.Proyecto.concesionario.entity.Trim;
import com.Proyecto.concesionario.service.IEstadoVehiculoService;
import com.Proyecto.concesionario.service.IMarcaService;
import com.Proyecto.concesionario.service.IModeloService;
import com.Proyecto.concesionario.service.IMotorService;
import com.Proyecto.concesionario.service.ITransmisionService;
import com.Proyecto.concesionario.service.ITrimService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarroDatosController {

    @Autowired
    private IModeloService modeloService;
    @Autowired
    private IMotorService motorService;
    @Autowired
    private ITransmisionService transmisionService;
    @Autowired
    private ITrimService trimService;
    @Autowired
    private IEstadoVehiculoService estadoVehiculoService;
    @Autowired
    private IMarcaService marcaService;

    @GetMapping("/manageCar")
    public String index(Model modelModelo, Model modelMarca, Model modalTransmision, Model modelMotor, Model modelTrim, Model modelEstado) {
        List<Marca> listaMarca = marcaService.getAllMarca();
        List<Modelo> listaModelo = modeloService.getAllModelo();
        List<Motor> listaMotor = motorService.getAllMotor();
        List<Transmision> listaTransmision = transmisionService.getAllTransmision();
        List<Trim> listaTrim = trimService.getAllTrim();
        List<EstadoVehiculo> listaEstado = estadoVehiculoService.getAllEstadoVehiculo();

        modelModelo.addAttribute("modelo", listaModelo);
        modelMarca.addAttribute("marca", listaMarca);
        modalTransmision.addAttribute("transmision", listaTransmision);
        modelMotor.addAttribute("motor", listaMotor);
        modelTrim.addAttribute("trim", listaTrim);
        modelEstado.addAttribute("estado", listaEstado);

        return "manageCar";
    }
    
      @Transactional
    @PostMapping("/marcaAgregar")
    public String agregarMarca(@RequestParam("marca") String marca) {
        marcaService.saveMarca(marca);
        return "redirect:/manageCar";
    }

    @Transactional
    @PostMapping("/modeloAgregar")
    public String agregarModelo(
            @RequestParam("modelo") String modelo
    ) {
        modeloService.saveModelo(modelo);
        return "redirect:/manageCar";
    }

    @Transactional
    @PostMapping("/transmisionAgregar")
    public String agregarTransmision(
            @RequestParam("transmision") String transmision
    ) {
        transmisionService.saveTransmision(transmision);
        return "redirect:/manageCar";
    }

    @Transactional
    @PostMapping("/estadoAgregar")
    public String agregarEstado(
            @RequestParam("estado") String estado
    ) {
        estadoVehiculoService.saveEstadoVehiculo(estado);
        return "redirect:/manageCar";
    }

    @Transactional
    @PostMapping("/motorAgregar")
    public String agregarMotor(
            @RequestParam("marca_id") long marca_id,
            @RequestParam("cilindraje") int cilindraje
    ) {
        motorService.saveMotor(cilindraje, marca_id);
        return "redirect:/manageCar";
    }

}
