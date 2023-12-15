package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "telefono")
public class Telefono {

    @Id
    @Column(name = "Tele_ID")
    private long teleID;

    @Column(name = "Tele_Bluetooth")
    private String teleBluetooth;

    @Column(name = "Tele_Fecha_Inicio")
    private Date teleFechaInicio;

    @Column(name = "Tele_Fecha_Fin")
    private Date teleFechaFin;

    @ManyToOne
    @JoinColumn(name = "Tele_FK_Usuario")
    private Usuario teleFKUsuario;

    @ManyToOne
    @JoinColumn(name = "Tele_FK_Querella")
    private Querella teleFKQuerella;


    public Telefono(){

    }

    public Telefono(long teleID) {
        this.teleID = teleID;
    }

    public long getTeleID() {
        return teleID;
    }

    public void setTeleID(long teleID) {
        this.teleID = teleID;
    }

    public String getTeleBluetooth() {
        return teleBluetooth;
    }

    public void setTeleBluetooth(String teleBluetooth) {
        this.teleBluetooth = teleBluetooth;
    }

    public Date getTeleFechaInicio() {
        return teleFechaInicio;
    }

    public void setTeleFechaInicio(Date teleFechaInicio) {
        this.teleFechaInicio = teleFechaInicio;
    }

    public Date getTeleFechaFin() {
        return teleFechaFin;
    }

    public void setTeleFechaFin(Date teleFechaFin) {
        this.teleFechaFin = teleFechaFin;
    }

    public Usuario getTeleFKUsuario() {
        return teleFKUsuario;
    }

    public void setTeleFKUsuario(Usuario teleFKUsuario) {
        this.teleFKUsuario = teleFKUsuario;
    }

    public Querella getTeleFKQuerella() {
        return teleFKQuerella;
    }

    public void setTeleFKQuerella(Querella teleFKQuerella) {
        this.teleFKQuerella = teleFKQuerella;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "teleID=" + teleID +
                ", teleBluetooth='" + teleBluetooth + '\'' +
                ", teleFechaInicio=" + teleFechaInicio +
                ", teleFechaFin=" + teleFechaFin +
                ", teleFKUsuario=" + teleFKUsuario +
                ", teleFKQuerella=" + teleFKQuerella +
                '}';
    }
}
