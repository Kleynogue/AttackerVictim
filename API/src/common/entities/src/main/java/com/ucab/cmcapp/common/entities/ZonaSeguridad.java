package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "Zona_Seguridad")
public class ZonaSeguridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Zon_Seg_ID", columnDefinition = "SERIAL")
    private long zonSegID;

    @Column(name = "Zon_Seg_Nombre")
    private String zonSegNombre;

    @ManyToOne
    @JoinColumn(name = "Zon_Seg_FK_Querella")
    private Querella zonSegFKQuerella;


    public ZonaSeguridad(){

    }

    public ZonaSeguridad(long zonSegID) {
        this.zonSegID = zonSegID;
    }

    public long getZonSegID() {
        return zonSegID;
    }

    public void setZonSegID(long zonSegID) {
        this.zonSegID = zonSegID;
    }

    public String getZonSegNombre() {
        return zonSegNombre;
    }

    public void setZonSegNombre(String zonSegNombre) {
        this.zonSegNombre = zonSegNombre;
    }

    public Querella getZonSegFKQuerella() {
        return zonSegFKQuerella;
    }

    public void setZonSegFKQuerella(Querella zonSegFKQuerella) {
        this.zonSegFKQuerella = zonSegFKQuerella;
    }

    @Override
    public String toString() {
        return "ZonaSeguridad{" +
                "zonSegID=" + zonSegID +
                ", zonSegNombre='" + zonSegNombre + '\'' +
                ", zonSegFKQuerella=" + zonSegFKQuerella +
                '}';
    }
}
