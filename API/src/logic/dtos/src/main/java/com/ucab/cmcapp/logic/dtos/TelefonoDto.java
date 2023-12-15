package com.ucab.cmcapp.logic.dtos;

public class TelefonoDto extends BaseDto{

    private String bluetooth;
    private String fechaInicio;
    private String fechaFin;
    private UsuarioDto usuario;
    private QuerellaDto querella;


    public TelefonoDto(){

    }

    public TelefonoDto(long id) {
        super(id);
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
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

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public QuerellaDto getQuerella() {
        return querella;
    }

    public void setQuerella(QuerellaDto querella) {
        this.querella = querella;
    }
}
