package com.ucab.cmcapp.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "punto_geografico")
public class PuntoGeografico {

    @Id
    @Column(name = "Pun_Geo_ID")
    private long punGeoID;

    @Column(name = "Pun_Geo_Latitud")
    private double punGeoLatitud;

    @Column(name = "Pun_Geo_Longitud")
    private double punGeoLongitud;


    public PuntoGeografico(){

    }

    public PuntoGeografico(long punGeoID) {
        this.punGeoID = punGeoID;
    }

    public long getPunGeoID() {
        return punGeoID;
    }

    public void setPunGeoID(long punGeoID) {
        this.punGeoID = punGeoID;
    }

    public double getPunGeoLatitud() {
        return punGeoLatitud;
    }

    public void setPunGeoLatitud(double punGeoLatitud) {
        this.punGeoLatitud = punGeoLatitud;
    }

    public double getPunGeoLongitud() {
        return punGeoLongitud;
    }

    public void setPunGeoLongitud(double punGeoLongitud) {
        this.punGeoLongitud = punGeoLongitud;
    }

    @Override
    public String toString() {
        return "PuntoGeografico{" +
                "punGeoID=" + punGeoID +
                ", punGeoLatitud=" + punGeoLatitud +
                ", punGeoLongitud=" + punGeoLongitud +
                '}';
    }
}
