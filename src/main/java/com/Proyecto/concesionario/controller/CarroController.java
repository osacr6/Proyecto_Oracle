package com.Proyecto.concesionario.controller;

import com.Proyecto.concesionario.entity.*;
import com.Proyecto.concesionario.service.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;


@Controller
public class CarroController {
    
    @Autowired
    private ICarroService carroService;
    
    @Autowired
    private ICotizacionService cotizacionService;
    
    @Autowired
    private IMarcaService marcaService;
    
    @Autowired
    private IProvinciaService provinciaService;
    
    @Autowired
    private IEstadoVehiculoService estadoVehiculoService;
    //funcion de JDBC
    @Autowired
    private JdbcTemplate jdbcTemplete;
    //prueba con el JDBC
    @GetMapping("/carro")
    public String index(Model model) {
        List<Carro> listaCarro = jdbcTemplete.query("SELECT * FROM T_CARRO", BeanPropertyRowMapper.newInstance(Carro.class));        
        model.addAttribute("carros", listaCarro);
        return "getAllCarros";
    }
    
    @GetMapping("/carro/getAll")
    public String getAllCarro(Model model) {
        //tomar la info del usuario logueado para validar si es administrador
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();                
        if(usuario.hasRole("ADMIN")){
            List<Carro> listaCarro = carroService.getAllCarro();
            model.addAttribute("titulo", "Tabla Carros");
            model.addAttribute("carros", listaCarro);
            return "getAllCarros";
        }        
        return "redirect:/home";  
    }
   
        @GetMapping("/marca/getAll")
    public String getAllMarca(Model model) {
        //tomar la info del usuario logueado para validar si es administrador
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();                
        if(usuario.hasRole("ADMIN")){
            List<Marca> listaMarcas = marcaService.listMarcas();
            model.addAttribute("titulo", "Tabla Carros");
            model.addAttribute("marcas", listaMarcas);
            return "getAllMarca";
        }          
        return "redirect:/home";  
     }
    
    @GetMapping("/carro/misCarros")
    public String getMyCars(Model model) {
        //tomar el id del usuario logueado
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();           
        long idUsuario = usuario.getUsuario_id();
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getCarro_id()== idUsuario){
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
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getEstado_id()== 1){
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
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getEstado_id()== 2){
                    carrosUsuario.add(c);
                }
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "getUsados";
    }
    
    @GetMapping("/carro/getVendidos")
    public String getVendidos(Model model) {        
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getEstado_id()== 3){
                    carrosUsuario.add(c);
                }
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "getVendidos";
    }
        
    @GetMapping("/carro/getMarca/{id}")
    public String getCarroByMarca(@PathVariable("id") Long idMarca ,Model model) {        
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        if(!listaCarro.isEmpty()){
            for(int i = 0; i<listaCarro.size(); i++){
                Carro c = listaCarro.get(i);
                if(c.getMarca_id()== idMarca){
                    carrosUsuario.add(c);
                }
            } 
        }                           
        model.addAttribute("carros", carrosUsuario);
        return "getMarca";
    }

    @GetMapping("/carro/create")
    public String create(Model model) {
        List<Marca> listaMarcas = marcaService.listMarcas(); 
        model.addAttribute("marcas", listaMarcas);     
        List<EstadoVehiculo> listaMarcas2 = estadoVehiculoService.getAll(); 
        model.addAttribute("marcas2", listaMarcas2);    
        List<Provincia> provincias = provinciaService.getAll(); 
        model.addAttribute("provincias", provincias);   
        model.addAttribute("carro", new Carro());           
        return "createCarro";
    }

    @PostMapping("/carro/create")
    public String create(@ModelAttribute Carro carro, @RequestParam("image") MultipartFile multipartFile) throws IOException {        
        //tomar el id del usuario logueado
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();        
        long idUsuario = usuario.getUsuario_id();
        //Nuevo registro
        if(carro.getCarro_id()== 0){
            carro.setRuta_Imagen(multipartFile.getOriginalFilename());   
            carroService.saveCarro(carro,multipartFile); 
        }//Actualizar registro
        else{
            //si no seleccionó imagen
            if(multipartFile.getOriginalFilename().equals("")){
                Carro c = carroService.getCarroById(carro.getCarro_id()); 
              //  carro.setIdUsuario(c.getCarro_id());
                carro.setRuta_Imagen(c.getRuta_Imagen());
                carroService.saveCarro(carro,multipartFile);  
            }else{
                Carro c = carroService.getCarroById(carro.getCarro_id()); 
                carro.setRuta_Imagen(multipartFile.getOriginalFilename());   
                carroService.saveCarro(carro,multipartFile);  
            } 
        }                                              
        return "redirect:/carro/misCarros";               
    }
    
    @GetMapping("/carro/cotizar/{id}")
    public String createCotizacion(@PathVariable("id") Long idCarro, Model model) {        
        //tomar el id del usuario logueado
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();        
        long idUsuario = usuario.getUsuario_id();
        Carro car = carroService.getCarroById(idCarro); 
        List<Cotizacion> cotizaciones = cotizacionService.getCotizaciones(); 
        //si el carro no pertenece al usuario que quiere cotizar
//        if(car.getCarro_id()!= idUsuario){
//            boolean cotizado = false;
//            for(int i = 0; i<cotizaciones.size(); i++){                                            
//                if(cotizaciones.get(i).getIdUsuario() == idUsuario){
//                    cotizado = true;
//                }
//            }
//            //si el carro no ha sido cotizado anteriormente por el usuario
//            if(!cotizado){
//                //obtener fecha actual
//                java.util.Date currDate = Calendar.getInstance().getTime();
//                Date todaysDate = new Date(currDate.getTime()); 
//                
//                Cotizacion cotizacion = new Cotizacion();
//                cotizacion.setIdCarro(idCarro);
//                cotizacion.setIdUsuario(idUsuario);
//                cotizacion.setFecha(todaysDate);
//                cotizacionService.saveCotizacion(cotizacion);
//                return "redirect:/carro/cotizacionRealizada";        
//            }
//        }    
        return "redirect:/carro/errorCotizacion";  
    }
    
    @GetMapping("/carro/misCotizaciones")
    public String getMisCotizaciones(Model model) {
        //tomar el id del usuario logueado
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();           
        long idUsuario = usuario.getUsuario_id();
        //consulta todos los carros
        List<Carro> listaCarro = carroService.getAllCarro(); 
        List<Carro> carrosUsuario = new ArrayList<>();
        //consulta todas las cotizaciones y las del usuario
        List<Cotizacion> listaCotizaciones = cotizacionService.getCotizaciones(); 
        List<Cotizacion> cotizacionesUsuario = new ArrayList<>();
        //si existen cotizaciones
//        if(!listaCotizaciones.isEmpty()){
//            //se recorren las cotizaciones y se almacenan en una lista las del usuario
//            for(int i = 0; i<listaCotizaciones.size(); i++){
//                Cotizacion c = listaCotizaciones.get(i);
//                if(c.getIdUsuario() == idUsuario){
//                    cotizacionesUsuario.add(c);
//                }
//            } 
//        } 
//        //si el usuario tiene cotizaciones
//        if(!cotizacionesUsuario.isEmpty()){            
//            for(int i = 0; i<listaCarro.size(); i++){
//                for(int y = 0; y<cotizacionesUsuario.size(); y++){
//                    Carro c = listaCarro.get(i);
//                    if(c.getId() == cotizacionesUsuario.get(y).getIdCarro()){
//                        carrosUsuario.add(c);
//                    }
//                }                
//            } 
//        }                           
        model.addAttribute("carros", carrosUsuario);
        return "misCotizaciones";
    }

    @GetMapping("/carro/errorCotizacion")
    public String errorCotizacion(Model model) {        
        return "errorCotizacion";
    }
    
    @GetMapping("/carro/cotizacionRealizada")
    public String cotizacionRealizada(Model model) {        
        return "cotizacionRealizada";
    }
    
    @GetMapping("/carro/deleteCotizacion/{id}")
    public String deleteCotizacion(@PathVariable("id") Long idCarro) {
        //tomar el id del usuario logueado
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();           
        long idUsuario = usuario.getUsuario_id();
        List<Cotizacion> listaCotizaciones = cotizacionService.getCotizaciones();
        for(int i = 0; i<listaCotizaciones.size(); i++){
//            if(listaCotizaciones.get(i).getIdCarro() == idCarro && listaCotizaciones.get(i).getIdUsuario()== idUsuario){
//                cotizacionService.delete(listaCotizaciones.get(i).getId());
//            }
        }        
        return "redirect:/carro/misCotizaciones";
    }
    
    @GetMapping("/carro/edit/{id}")
    public String edit(@PathVariable("id") Long idCarro, Model model) {
        List<Marca> listaMarcas = marcaService.listMarcas(); 
        model.addAttribute("marcas", listaMarcas);     
        List<EstadoVehiculo> listaMarcas2 = estadoVehiculoService.getAll(); 
        model.addAttribute("marcas2", listaMarcas2);    
        List<Provincia> provincias = provinciaService.getAll(); 
        model.addAttribute("provincias", provincias);  
        Carro carro = carroService.getCarroById(idCarro);              
        model.addAttribute("carro", carro);         
        return "editCarro";
    }   
    
    @GetMapping("/carro/details/{id}")
    public String details(@PathVariable("id") Long idCarro, Model model) {         
        Carro carro = carroService.getCarroById(idCarro);              
        model.addAttribute("carro", carro);         
        return "detailsCarro";
    }  
    
    @GetMapping("/carro/delete/{id}")
    public String deleteCarro(@PathVariable("id") Long idCarro) {
        carroService.delete(idCarro);
        return "redirect:/carro/getAll";
    }
    
    @GetMapping("/carro/deleteMyCar/{id}")
    public String deleteMyCar(@PathVariable("id") Long idCarro) {
        carroService.delete(idCarro);
        return "redirect:/carro/misCarros";
    }
}
    

