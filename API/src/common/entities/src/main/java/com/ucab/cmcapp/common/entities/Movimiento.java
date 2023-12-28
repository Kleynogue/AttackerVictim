package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Movi_ID", columnDefinition = "SERIAL")
    private long moviID;

    @Column(name = "Movi_X")
    private double moviX;

    @Column(name = "Movi_Y")
    private double moviY;

    @Column(name = "Movi_Z")
    private double moviZ;

    @Column(name = "Movi_Fecha")
    private Date moviFecha;

    @ManyToOne
    @JoinColumn(name = "Movi_FK_Telefono")
    private Telefono moviFKTelefono;


    public Movimiento(){

    }

    public Movimiento(long moviID) {
        this.moviID = moviID;
    }

    public long getMoviID() {
        return moviID;
    }

    public void setMoviID(long moviID) {
        this.moviID = moviID;
    }

    public double getMoviX() {
        return moviX;
    }

    public void setMoviX(double moviX) {
        this.moviX = moviX;
    }

    public double getMoviY() {
        return moviY;
    }

    public void setMoviY(double moviY) {
        this.moviY = moviY;
    }

    public double getMoviZ() {
        return moviZ;
    }

    public void setMoviZ(double moviZ) {
        this.moviZ = moviZ;
    }

    public Date getMoviFecha() {
        return moviFecha;
    }

    public void setMoviFecha(Date moviFecha) {
        this.moviFecha = moviFecha;
    }

    public Telefono getMoviFKTelefono() {
        return moviFKTelefono;
    }

    public void setMoviFKTelefono(Telefono moviFKTelefono) {
        this.moviFKTelefono = moviFKTelefono;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "moviID=" + moviID +
                ", moviX=" + moviX +
                ", moviY=" + moviY +
                ", moviZ=" + moviZ +
                ", moviFecha=" + moviFecha +
                ", moviFKTelefono=" + moviFKTelefono +
                '}';
    }
}
