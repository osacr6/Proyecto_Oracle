 package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="T_CANTON")
public class Canton implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long canton_id; 
    private String canton;  

    public long getCanton_id() {
        return canton_id;
    }

    public void setCanton_id(long canton_id) {
        this.canton_id = canton_id;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }




}
