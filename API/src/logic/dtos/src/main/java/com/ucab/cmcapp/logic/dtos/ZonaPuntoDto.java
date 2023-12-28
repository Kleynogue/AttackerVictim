package com.ucab.cmcapp.logic.dtos;

public class ZonaPuntoDto extends BaseDto{

    private ZonaSeguridadDto zona;
    private PuntoGeograficoDto punto;


    public ZonaPuntoDto(long id) {
        super(id);
    }

    public ZonaPuntoDto() {
    }

    public ZonaSeguridadDto getZona() {
        return zona;
    }

    public void setZona(ZonaSeguridadDto zona) {
        this.zona = zona;
    }

    public PuntoGeograficoDto getPunto() {
        return punto;
    }

    public void setPunto(PuntoGeograficoDto punto) {
        this.punto = punto;
    }

    @Override
    public String toString() {
        return "ZonaPuntoDto{" +
                "zona=" + zona +
                ", punto=" + punto +
                ", _id=" + _id +
                '}';
    }
}
