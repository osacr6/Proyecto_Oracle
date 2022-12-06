package com.Proyecto.concesionario.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="T_COTIZACION")
public class Cotizacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cotizacion_id;
    private long factura_id;
    private long banco_id;
    private int prima;  

    public long getCotizacion_id() {
        return cotizacion_id;
    }

    public void setCotizacion_id(long cotizacion_id) {
        this.cotizacion_id = cotizacion_id;
    }

    public long getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(long factura_id) {
        this.factura_id = factura_id;
    }

    public long getBanco_id() {
        return banco_id;
    }

    public void setBanco_id(long banco_id) {
        this.banco_id = banco_id;
    }

    public int getPrima() {
        return prima;
    }

    public void setPrima(int prima) {
        this.prima = prima;
    }

      
}
