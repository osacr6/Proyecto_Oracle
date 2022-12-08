/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.Canton;
import com.Proyecto.concesionario.entity.Direccion;
import com.Proyecto.concesionario.entity.Distrito;
import com.Proyecto.concesionario.entity.Provincia;
import com.Proyecto.concesionario.entity.Sucursal;
import com.Proyecto.concesionario.service.ICantonService;
import com.Proyecto.concesionario.service.IDireccionService;
import com.Proyecto.concesionario.service.IDistritoService;
import com.Proyecto.concesionario.service.IProvinciaService;
import com.Proyecto.concesionario.service.ISucursalService;
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
public class SucursalController {

    @Autowired
    private IProvinciaService provinciaService;
    @Autowired
    private ICantonService cantonService;
    @Autowired
    private IDistritoService distritoService;
    @Autowired
    private IDireccionService direccionService;
    @Autowired
    private ISucursalService sucursalService;

    @GetMapping("/office")
    public String index(Model modelProvincia, Model modelCanton, Model modelDistrito, Model modelDireccion, Model modelSucursal) {
        List<Provincia> listaProvincia = provinciaService.getAllProvincia();
        List<Canton> listaCanton = cantonService.getAllCanton();
        List<Distrito> listaDistrito = distritoService.getAllDistrito();
        List<Direccion> listaDireccion = direccionService.getAllDireccion();
        List<Sucursal> listaSucursal = sucursalService.getAllSucursal();

        modelProvincia.addAttribute("provincia", listaProvincia);
        modelCanton.addAttribute("canton", listaCanton);
        modelDistrito.addAttribute("distrito", listaDistrito);
        modelDireccion.addAttribute("direccion", listaDireccion);
        modelSucursal.addAttribute("sucursal", listaSucursal);

        return "office";
    }

    @Transactional
    @PostMapping("/provinciaAgregar")
    public String agregarProvincia(@RequestParam("provincia") String provincia) {
        provinciaService.saveProvincia(provincia);
        return "redirect:/office";
    }

    @Transactional
    @PostMapping("/cantonAgregar")
    public String agregarCanton(
            @RequestParam("canton") String canton
    ) {
        cantonService.saveCanton(canton);
        return "redirect:/office";
    }

    @Transactional
    @PostMapping("/distritoAgregar")
    public String agregarDistrito(
            @RequestParam("distrito") String distrito
    ) {
        distritoService.saveDistrito(distrito);
        return "redirect:/office";
    }

    @Transactional
    @PostMapping("/direccionAgregar")
    public String agregarDireccion(
            @RequestParam("provincia_id") long provincia,
            @RequestParam("canton_id") long canton,
            @RequestParam("distrito_id") long distrito,
            @RequestParam("detalles") String detalles,
            @RequestParam("ubicacion") String ubicacion
    ) {
        direccionService.saveDireccion(provincia, canton, distrito, detalles, ubicacion);
        return "redirect:/office";
    }

    @Transactional
    @PostMapping("/sucursalAgregar")
    public String agregarSucursal(
            @RequestParam("direccion_id") long direccion,
            @RequestParam("numero") int numero,
            @RequestParam("nombre") String nombre,
            @RequestParam("telefono") String telefono
    ) {
        sucursalService.saveSucursal(direccion, numero, nombre, telefono);
        return "redirect:/office";
    }
}
