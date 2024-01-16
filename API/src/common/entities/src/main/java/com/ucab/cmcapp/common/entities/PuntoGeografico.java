package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "punto_geografico")
public class PuntoGeografico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pun_Geo_ID", columnDefinition = "SERIAL")
    private long punGeoID;

    @Column(name = "Pun_Geo_Latitud")
    private double punGeoLatitud;

    @Column(name = "Pun_Geo_Longitud")
    private double punGeoLongitud;

    @Column(name = "Pun_Geo_Status")
    private String punGeoStatus;


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

    public String getPunGeoStatus() {
        return punGeoStatus;
    }

    public void setPunGeoStatus(String punGeoStatus) {
        this.punGeoStatus = punGeoStatus;
    }

    @Override
    public String toString() {
        return "PuntoGeografico{" +
                "punGeoID=" + punGeoID +
                ", punGeoLatitud=" + punGeoLatitud +
                ", punGeoLongitud=" + punGeoLongitud +
                ", punGeoStatus='" + punGeoStatus + '\'' +
                '}';
    }
}
