package com.ucab.cmcapp.logic.dtos;

public class QuerellaDto extends BaseDto{

    private double distanciaMin;
    private int tiempoControl;
    private String status;


    public QuerellaDto(){
    }

    public QuerellaDto(long id) {
        super(id);
    }

    public double getDistanciaMin() {
        return distanciaMin;
    }

    public void setDistanciaMin(double distanciaMin) {
        this.distanciaMin = distanciaMin;
    }

    public int getTiempoControl() {
        return tiempoControl;
    }

    public void setTiempoControl(int tiempoControl) {
        this.tiempoControl = tiempoControl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QuerellaDto{" +
                "distanciaMin=" + distanciaMin +
                ", tiempoControl=" + tiempoControl +
                ", status='" + status + '\'' +
                ", _id=" + _id +
                '}';
    }
}
