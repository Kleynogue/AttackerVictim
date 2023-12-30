package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

import java.util.Date;

@Entity()
@Table(name = "historico_punto")
public class HistoricoPunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Hist_Pun_ID", columnDefinition = "SERIAL")
    private long histPunID;

    @Column(name = "Hist_Pun_Fecha_Inicio")
    private Date histPunFechaInicio;

    @Column(name = "Hist_Pun_Fecha_Fin")
    private Date histPunFechaFin;

    @ManyToOne
    @JoinColumn(name = "Hist_Pun_FK_Telefono")
    private Telefono histPunFKTelefono;

    @ManyToOne
    @JoinColumn(name = "Hist_Pun_FK_Punto_Geografico")
    private PuntoGeografico histPunFKPuntoGeografico;


    public HistoricoPunto(){

    }

    public HistoricoPunto(long histPunID) {
        this.histPunID = histPunID;
    }

    public long getHistPunID() {
        return histPunID;
    }

    public void setHistPunID(long histPunID) {
        this.histPunID = histPunID;
    }

    public Date getHistPunFechaInicio() {
        return histPunFechaInicio;
    }

    public void setHistPunFechaInicio(Date histPunFechaInicio) {
        this.histPunFechaInicio = histPunFechaInicio;
    }

    public Date getHistPunFechaFin() {
        return histPunFechaFin;
    }

    public void setHistPunFechaFin(Date histPunFechaFin) {
        this.histPunFechaFin = histPunFechaFin;
    }

    public Telefono getHistPunFKTelefono() {
        return histPunFKTelefono;
    }

    public void setHistPunFKTelefono(Telefono histPunFKTelefono) {
        this.histPunFKTelefono = histPunFKTelefono;
    }

    public PuntoGeografico getHistPunFKPuntoGeografico() {
        return histPunFKPuntoGeografico;
    }

    public void setHistPunFKPuntoGeografico(PuntoGeografico histPunFKPuntoGeografico) {
        this.histPunFKPuntoGeografico = histPunFKPuntoGeografico;
    }

    @Override
    public String toString() {
        return "HistoricoPunto{" +
                "histPunID=" + histPunID +
                ", histPunFechaInicio=" + histPunFechaInicio +
                ", histPunFechaFin=" + histPunFechaFin +
                ", histPunFKTelefono=" + histPunFKTelefono +
                ", histPunFKPuntoGeografico=" + histPunFKPuntoGeografico +
                '}';
    }
}
