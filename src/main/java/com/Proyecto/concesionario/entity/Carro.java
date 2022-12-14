package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_CARRO")
public class Carro implements Serializable {
   
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long carro_id;
    @Column
    private long marca_id; 
    @Column
    private long modelo_id;
    @Column
    private long trim_id; 
    @Column
    private long sucursal_id; 
    @Column
    private long estado_id;    
    @Column
    private String placa;
    @Column
    private int color_interior;
    @Column
    private int color_exterior;
    @Column
    private int kilometraje;
    @Column
    private int precio;
    @Column
    private String vin;

    public long getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(long carro_id) {
        this.carro_id = carro_id;
    }

    public long getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(long marca_id) {
        this.marca_id = marca_id;
    }

    public long getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(long modelo_id) {
        this.modelo_id = modelo_id;
    }

    public long getTrim_id() {
        return trim_id;
    }

    public void setTrim_id(long trim_id) {
        this.trim_id = trim_id;
    }

    public long getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(long sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public long getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(long estado_id) {
        this.estado_id = estado_id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getColor_interior() {
        return color_interior;
    }

    public void setColor_interior(int color_interior) {
        this.color_interior = color_interior;
    }

    public int getColor_exterior() {
        return color_exterior;
    }

    public void setColor_exterior(int color_exterior) {
        this.color_exterior = color_exterior;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

}
