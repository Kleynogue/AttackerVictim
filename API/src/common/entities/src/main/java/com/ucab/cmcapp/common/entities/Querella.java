package com.ucab.cmcapp.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "querella")
public class Querella {

    @Id
    @Column(name = "Quer_ID")
    private long querID;

    @Column(name = "Quer_Distancia_Min")
    private double querDistanciaMin;

    @Column(name = "Quer_Tiempo_Control")
    private int querTiempoControl;

    @Column(name = "Quer_Status")
    private String querStatus;


    public Querella(){

    }

    public Querella(long querID) {
        this.querID = querID;
    }

    public long getQuerID() {
        return querID;
    }

    public void setQuerID(long querID) {
        this.querID = querID;
    }

    public double getQuerDistanciaMin() {
        return querDistanciaMin;
    }

    public void setQuerDistanciaMin(double querDistanciaMin) {
        this.querDistanciaMin = querDistanciaMin;
    }

    public int getQuerTiempoControl() {
        return querTiempoControl;
    }

    public void setQuerTiempoControl(int querTiempoControl) {
        this.querTiempoControl = querTiempoControl;
    }

    public String getQuerStatus() {
        return querStatus;
    }

    public void setQuerStatus(String querStatus) {
        this.querStatus = querStatus;
    }

    @Override
    public String toString() {
        return "Querella{" +
                "querID=" + querID +
                ", querDistanciaMin=" + querDistanciaMin +
                ", querTiempoControl=" + querTiempoControl +
                ", querStatus='" + querStatus + '\'' +
                '}';
    }
}
