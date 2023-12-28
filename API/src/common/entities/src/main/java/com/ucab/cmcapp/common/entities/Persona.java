package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pers_ID", columnDefinition = "SERIAL")
    private long persID;

    @Column(name = "Pers_Nombre")
    private String persNombre;

    @Column(name = "Pers_Apellido")
    private String persApellido;

    @Column(name = "Pers_Direccion")
    private String persDireccion;

    public Persona(){

    }

    public Persona(long persID) {
        this.persID = persID;
    }

    public long getPersID() {
        return persID;
    }

    public void setPersID(long persID) {
        this.persID = persID;
    }

    public String getPersNombre() {
        return persNombre;
    }

    public void setPersNombre(String persNombre) {
        this.persNombre = persNombre;
    }

    public String getPersApellido() {
        return persApellido;
    }

    public void setPersApellido(String persApellido) {
        this.persApellido = persApellido;
    }

    public String getPersDireccion() {
        return persDireccion;
    }

    public void setPersDireccion(String persDireccion) {
        this.persDireccion = persDireccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "persID=" + persID +
                ", persNombre='" + persNombre + '\'' +
                ", persApellido='" + persApellido + '\'' +
                ", persDireccion='" + persDireccion + '\'' +
                '}';
    }
}
