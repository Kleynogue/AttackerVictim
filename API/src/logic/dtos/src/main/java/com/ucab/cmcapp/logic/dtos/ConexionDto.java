package com.ucab.cmcapp.logic.dtos;

public class ConexionDto extends BaseDto{

    public String date;
    public TelefonoDto telefono;


    public ConexionDto(long id) {
        super(id);
    }

    public ConexionDto() {
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

    @Override
    public String toString() {
        return "ConexionDto{" +
                "date='" + date + '\'' +
                ", telefono=" + telefono +
                ", _id=" + _id +
                '}';
    }
}
