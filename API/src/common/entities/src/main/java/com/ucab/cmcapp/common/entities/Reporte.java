package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reporte")
public class Reporte {

    @Id
    @Column(name = "Repo_ID")
    private long repoID;

    @Column(name = "Repo_Fecha")
    private Date repoFecha;

    @Column(name = "Repo_Tipo")
    private String repoTipo;

    @ManyToOne
    @JoinColumn(name = "Repo_FK_Telefono")
    private Telefono repoFKTelefono;

    @ManyToOne
    @JoinColumn(name = "Repo_FK_Punto_Geografico")
    private PuntoGeografico repoFKPuntoGeografico;


    public Reporte(){

    }

    public Reporte(long repoID) {
        this.repoID = repoID;
    }

    public long getRepoID() {
        return repoID;
    }

    public void setRepoID(long repoID) {
        this.repoID = repoID;
    }

    public Date getRepoFecha() {
        return repoFecha;
    }

    public void setRepoFecha(Date repoFecha) {
        this.repoFecha = repoFecha;
    }

    public String getRepoTipo() {
        return repoTipo;
    }

    public void setRepoTipo(String repoTipo) {
        this.repoTipo = repoTipo;
    }

    public Telefono getRepoFKTelefono() {
        return repoFKTelefono;
    }

    public void setRepoFKTelefono(Telefono repoFKTelefono) {
        this.repoFKTelefono = repoFKTelefono;
    }

    public PuntoGeografico getRepoFKPuntoGeografico() {
        return repoFKPuntoGeografico;
    }

    public void setRepoFKPuntoGeografico(PuntoGeografico repoFKPuntoGeografico) {
        this.repoFKPuntoGeografico = repoFKPuntoGeografico;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "repoID=" + repoID +
                ", repoFecha=" + repoFecha +
                ", repoTipo='" + repoTipo + '\'' +
                ", repoFKTelefono=" + repoFKTelefono +
                ", repoFKPuntoGeografico=" + repoFKPuntoGeografico +
                '}';
    }
}
