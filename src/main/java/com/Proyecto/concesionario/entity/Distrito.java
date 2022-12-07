 package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="T_DISTRITO")
public class Distrito implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long distrito_id; 
    private String distrito;  

    public long getDistrito_id() {
        return distrito_id;
    }

    public void setDistrito_id(long distrito_id) {
        this.distrito_id = distrito_id;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

   


}
