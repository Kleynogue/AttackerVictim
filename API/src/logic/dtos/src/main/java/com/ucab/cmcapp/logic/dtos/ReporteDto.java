package com.ucab.cmcapp.logic.dtos;

public class ReporteDto extends BaseDto{

    private String date;
    private String type;
    private TelefonoDto telefono;
    private PuntoGeograficoDto puntoGeografico;


    public ReporteDto(long id) {
        super(id);
    }

    public ReporteDto() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
