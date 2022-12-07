 package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="T_SUCURSAL")
public class Sucursal implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sucursal_id;
    private int numero;
    private String nombre;
    private String telefono;
    private long direccion_id;

    public long getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(long sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public long getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(long direccion_id) {
        this.direccion_id = direccion_id;
    }



}
