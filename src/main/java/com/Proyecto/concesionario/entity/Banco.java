package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="T_BANCO")
public class Banco implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long banco_id; 
   private String banco;
   private float tasa;

    public long getBanco_id() {
        return banco_id;
    }

    public void setBanco_id(long banco_id) {
        this.banco_id = banco_id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

}
