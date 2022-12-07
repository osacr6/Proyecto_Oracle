package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PROVINCIA")
public class Provincia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long provincia_id;
    @Column(name = "provincia")
    private String provincia;

    public long getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(long provincia_id) {
        this.provincia_id = provincia_id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
