package com.ucab.cmcapp.logic.dtos;

public class PuntoGeograficoDto extends BaseDto{

    private double latitude;
    private double longitude;


    public PuntoGeograficoDto(){
    }

    public PuntoGeograficoDto(long id) {
        super(id);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
