package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
   @Table(name ="T_ESTADO")
public class EstadoVehiculo implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long estado_id; 
   private String estado;

    public long getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(long estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
}
