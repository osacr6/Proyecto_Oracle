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
@Table(name = "T_MOTOR")
public class Motor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long motor_id;
    @Column
    private int cilindraje;
    @Column
    private long marca_id;

    public long getMotor_id() {
        return motor_id;
    }

    public void setMotor_id(long motor_id) {
        this.motor_id = motor_id;
    }

    public long getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(long marca_id) {
        this.marca_id = marca_id;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
}
