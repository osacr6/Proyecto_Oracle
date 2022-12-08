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
@Table(name = "T_TRIM")
public class Trim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long trim_id;
    @Column
    private String codigo;
    @Column
    private int motor_id;
    @Column
    private int transmision_id;
    @Column
    private int numero_puertas;

    public long getTrim_id() {
        return trim_id;
    }

    public void setTrim_id(long trim_id) {
        this.trim_id = trim_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getMotor_id() {
        return motor_id;
    }

    public void setMotor_id(int motor_id) {
        this.motor_id = motor_id;
    }

    public int getTransmision_id() {
        return transmision_id;
    }

    public void setTransmision_id(int transmision_id) {
        this.transmision_id = transmision_id;
    }

    public int getNumero_puertas() {
        return numero_puertas;
    }

    public void setNumero_puertas(int numero_puertas) {
        this.numero_puertas = numero_puertas;
    }

}
