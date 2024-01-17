package com.ucab.cmcapp.logic.dtos;

public class PuntoGeograficoDto extends BaseDto{

    private double latitude;
    private double longitude;

    private String status;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PuntoGeograficoDto{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", status='" + status + '\'' +
                ", _id=" + _id +
                '}';
    }
}
