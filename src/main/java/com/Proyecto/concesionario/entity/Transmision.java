/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_TRANSMISION")
public class Transmision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long transmision_id;
    @Column
    private String transmision;

    public long getTransmision_id() {
        return transmision_id;
    }

    public void setTransmision_id(long transmision_id) {
        this.transmision_id = transmision_id;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String trasmision) {
        this.transmision = trasmision;
    }
    
}
