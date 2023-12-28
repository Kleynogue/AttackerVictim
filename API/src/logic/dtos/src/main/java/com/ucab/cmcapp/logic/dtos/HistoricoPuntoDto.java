package com.ucab.cmcapp.logic.dtos;

public class HistoricoPuntoDto extends BaseDto{

    private String fechaInicio;
    private String fechaFin;
    private TelefonoDto telefono;
    private PuntoGeograficoDto puntoGeografico;


    public HistoricoPuntoDto(long id) {
        super(id);
    }

    public HistoricoPuntoDto() {
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public TelefonoDto getTelefono() {
        return telefono;
    }

    public void setTelefono(TelefonoDto telefono) {
        this.telefono = telefono;
    }

    public PuntoGeograficoDto getPuntoGeografico() {
        return puntoGeografico;
    }

    public void setPuntoGeografico(PuntoGeograficoDto puntoGeografico) {
        this.puntoGeografico = puntoGeografico;
    }

    @Override
    public String toString() {
        return "HistoricoPuntoDto{" +
                "fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", telefono=" + telefono +
                ", puntoGeografico=" + puntoGeografico +
                ", _id=" + _id +
                '}';
    }
}
