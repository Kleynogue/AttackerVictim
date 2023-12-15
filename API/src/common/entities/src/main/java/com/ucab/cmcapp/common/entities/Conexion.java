package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "conexion")
public class Conexion {

    @Id
    @Column(name = "Cone_ID")
    private long coneID;

    @Column(name = "Cone_Fecha")
    private Date coneFecha;

    @ManyToOne
    @JoinColumn(name = "Cone_FK_Telefono")
    private Telefono coneFKTelefono;


    public Conexion(){

    }

    public Conexion(long coneID) {
        this.coneID = coneID;
    }

    public long getConeID() {
        return coneID;
    }

    public void setConeID(long coneID) {
        this.coneID = coneID;
    }

    public Date getConeFecha() {
        return coneFecha;
    }

    public void setConeFecha(Date coneFecha) {
        this.coneFecha = coneFecha;
    }

    public Telefono getConeFKTelefono() {
        return coneFKTelefono;
    }

    public void setConeFKTelefono(Telefono coneFKTelefono) {
        this.coneFKTelefono = coneFKTelefono;
    }

    @Override
    public String toString() {
        return "Conexion{" +
                "coneID=" + coneID +
                ", coneFecha=" + coneFecha +
                ", coneFKTelefono=" + coneFKTelefono +
                '}';
    }
}
