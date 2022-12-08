package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.*;
import com.Proyecto.concesionario.service.*;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarroController {

    @Autowired
    private ICarroService carroService;

    @Autowired
    private IMarcaService marcaService;

    @Autowired
    private IModeloService modeloService;

    @Autowired
    private ITrimService trimService;

    @Autowired
    private ISucursalService sucursalService;

    @Autowired
    private IMotorService motorService;

    @Autowired
    private ITransmisionService transmisionService;

    @Autowired
    private IEstadoVehiculoService estadoVehiculoService;

    @GetMapping("/carro")
    public String getAllCarro(Model model) {
        //tomar la info del usuario logueado para validar si es administrador
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (usuario.hasRole("ADMIN")) {
            List<Carro> listaCarro = carroService.getAllCarro();
            List<Marca> listaMarcas = marcaService.getAllMarca();
            List<Modelo> listaModelo = modeloService.getAllModelo();
            List<Trim> listaTrim = trimService.getAllTrim();
            List<Sucursal> listaSucursal = sucursalService.getAllSucursal();
            List<Motor> listaMotor = motorService.getAllMotor();
            List<Transmision> listaTransmision = transmisionService.getAllTransmision();
            List<EstadoVehiculo> listaEstado = estadoVehiculoService.getAllEstadoVehiculo();
            model.addAttribute("titulo", "Tabla Carros");
            model.addAttribute("carro", listaCarro);
            model.addAttribute("marca", listaMarcas);
            model.addAttribute("modelo", listaModelo);
            model.addAttribute("trim", listaTrim);
            model.addAttribute("sucursal", listaSucursal);
            model.addAttribute("motor", listaMotor);
            model.addAttribute("transmision", listaTransmision);
            model.addAttribute("estado", listaEstado);
            return "carro";
        }
        return "redirect:/home";
    }

    @Transactional
    @PostMapping("/carroCrear")
    public String createCarro(
            @RequestParam("marca_id") long marca_id,
            @RequestParam("modelo_id") long modelo_id,
            @RequestParam("trim_id") long trim_id,
            @RequestParam("sucursal_id") long sucursal_id,
            @RequestParam("estado_id") long estado_id,
            @RequestParam("placa") String placa,
            @RequestParam("color_interior") int color_interior,
            @RequestParam("color_exterior") int color_exterior,
            @RequestParam("kilometraje") int kilometraje,
            @RequestParam("precio") int precio,
            @RequestParam("vin") String vin
    ) {

        carroService.save(marca_id, modelo_id, trim_id, sucursal_id, estado_id, placa, color_interior, color_exterior, kilometraje, precio, vin);
        return "redirect:/carro";
    }

    @Transactional
    @PostMapping("/carroUpdate")
    public String updateCarro(
            @RequestParam("carro_id") long carro_id,
            @RequestParam("marca_id") long marca_id,
            @RequestParam("modelo_id") long modelo_id,
            @RequestParam("trim_id") long trim_id,
            @RequestParam("sucursal_id") long sucursal_id,
            @RequestParam("estado_id") long estado_id,
            @RequestParam("placa") String placa,
            @RequestParam("color_interior") int color_interior,
            @RequestParam("color_exterior") int color_exterior,
            @RequestParam("kilometraje") int kilometraje,
            @RequestParam("precio") int precio,
            @RequestParam("vin") String vin
    ) {
        carroService.UpdateCarro(carro_id, marca_id, modelo_id, trim_id, sucursal_id, estado_id, placa,
                color_interior, color_exterior, kilometraje, precio, vin);
        return "redirect:/carro";
    }
        @Transactional
    @PostMapping("/carroEliminar/{id}")
    public String eliminarCarro(
            @PathVariable("id") long carro_id
    ) {
       carroService.delete(carro_id);
        return "redirect:/carro";
    }

    @Transactional
    @PostMapping("/trimCrear")
    public String createTrim(
            @RequestParam("codigo") String codigo,
            @RequestParam("motor_id") long motor_id,
            @RequestParam("transmision_id") long transmision_id,
            @RequestParam("numero_puertas") int numero_puertas
    ) {
        trimService.saveTrim(codigo, motor_id, transmision_id, numero_puertas);
        return "redirect:/carro";
    }

    @Transactional
    @PostMapping("/trimUpdate")
    public String updateTrim(
            @RequestParam("trim_id") long trim_id,
            @RequestParam("codigo") String codigo,
            @RequestParam("motor_id") long motor_id,
            @RequestParam("transmision_id") long transmision_id,
            @RequestParam("numero_puertas") int numero_puertas
    ) {
        trimService.updateTrim(trim_id, codigo, motor_id, transmision_id, numero_puertas);
        return "redirect:/carro";
    }

    @GetMapping("/carro/misCarros")
    public String getMyCars(Model model) {
        //tomar el id del usuario logueado
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long idUsuario = usuario.getUsuario_id();
        List<Carro> listaCarro = carroService.getAllCarro();
        List<Carro> carrosUsuario = new ArrayList<>();
        if (!listaCarro.isEmpty()) {
            for (int i = 0; i < listaCarro.size(); i++) {
                Carro c = listaCarro.get(i);
                if (c.getCarro_id() == idUsuario) {
                    carrosUsuario.add(c);
                }
            }
        }
        model.addAttribute("carros", carrosUsuario);
        return "myCars";
    }

    @GetMapping("/carro/getNuevos")
    public String getNuevos(Model model) {
        List<Carro> listaCarro = carroService.getAllCarro();
        List<Carro> carrosUsuario = new ArrayList<>();
        if (!listaCarro.isEmpty()) {
            for (int i = 0; i < listaCarro.size(); i++) {
                Carro c = listaCarro.get(i);
                if (c.getEstado_id() == 1) {
                    carrosUsuario.add(c);
                }
            }
        }
        model.addAttribute("carros", carrosUsuario);
        return "getNuevos";
    }

    @GetMapping("/carro/getUsados")
    public String getUsados(Model model) {
        List<Carro> listaCarro = carroService.getAllCarro();
        List<Carro> carrosUsuario = new ArrayList<>();
        if (!listaCarro.isEmpty()) {
            for (int i = 0; i < listaCarro.size(); i++) {
                Carro c = listaCarro.get(i);
                if (c.getEstado_id() == 2) {
                    carrosUsuario.add(c);
                }
            }
        }
        model.addAttribute("carros", carrosUsuario);
        return "getUsados";
    }

    @GetMapping("/carro/getMarca/{id}")
    public String getCarroByMarca(@PathVariable("id") Long idMarca, Model model) {
        List<Carro> listaCarro = carroService.getAllCarro();
        List<Carro> carrosUsuario = new ArrayList<>();
        if (!listaCarro.isEmpty()) {
            for (int i = 0; i < listaCarro.size(); i++) {
                Carro c = listaCarro.get(i);
                if (c.getMarca_id() == idMarca) {
                    carrosUsuario.add(c);
                }
            }
        }
        model.addAttribute("carros", carrosUsuario);
        return "getMarca";
    }
}
