package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zona_punto")
public class ZonaPunto implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "Zon_Pun_FK_Punto_Geografico")
    private PuntoGeografico zonPunFKPuntoGeografico;

    @Id
    @ManyToOne
    @JoinColumn(name = "Zon_Pun_FK_Zona_Seguridad")
    private ZonaSeguridad zonPunFKZonaSeguridad;


    public ZonaPunto(){

    }

    public ZonaPunto(PuntoGeografico zonPunFKPuntoGeografico, ZonaSeguridad zonPunFKZonaSeguridad) {
        this.zonPunFKPuntoGeografico = zonPunFKPuntoGeografico;
        this.zonPunFKZonaSeguridad = zonPunFKZonaSeguridad;
    }

    public PuntoGeografico getZonPunFKPuntoGeografico() {
        return zonPunFKPuntoGeografico;
    }

    public void setZonPunFKPuntoGeografico(PuntoGeografico zonPunFKPuntoGeografico) {
        this.zonPunFKPuntoGeografico = zonPunFKPuntoGeografico;
    }

    public ZonaSeguridad getZonPunFKZonaSeguridad() {
        return zonPunFKZonaSeguridad;
    }

    public void setZonPunFKZonaSeguridad(ZonaSeguridad zonPunFKZonaSeguridad) {
        this.zonPunFKZonaSeguridad = zonPunFKZonaSeguridad;
    }

    @Override
    public String toString() {
        return "ZonaPunto{" +
                "zonPunFKPuntoGeografico=" + zonPunFKPuntoGeografico +
                ", zonPunFKZonaSeguridad=" + zonPunFKZonaSeguridad +
                '}';
    }
}
