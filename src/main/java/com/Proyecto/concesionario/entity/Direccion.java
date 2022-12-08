 package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="T_DIRECCION")
public class Direccion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long direccion_id;
    @Column
    private long provincia_id;
    @Column
    private long canton_id;
    @Column
    private long distrito_id;
    @Column
    private String detalles;
    @Column
    private String ubicacion;

    public long getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(long direccion_id) {
        this.direccion_id = direccion_id;
    }

    public long getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(long provincia_id) {
        this.provincia_id = provincia_id;
    }

    public long getCanton_id() {
        return canton_id;
    }

    public void setCanton_id(long canton_id) {
        this.canton_id = canton_id;
    }

    public long getDistrito_id() {
        return distrito_id;
    }

    public void setDistrito_id(long distrito_id) {
        this.distrito_id = distrito_id;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    


}
