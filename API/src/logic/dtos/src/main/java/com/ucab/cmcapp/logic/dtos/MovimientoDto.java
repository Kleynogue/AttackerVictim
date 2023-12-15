package com.ucab.cmcapp.logic.dtos;

public class MovimientoDto extends BaseDto{

    private double x;
    private double y;
    private double z;
    private String date;
    private TelefonoDto telefono;


    public MovimientoDto(long id) {
        super(id);
    }

    public MovimientoDto() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TelefonoDto getTelefono() {
        return telefono;
    }

    public void setTelefono(TelefonoDto telefono) {
        this.telefono = telefono;
    }
}
