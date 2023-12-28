package com.ucab.cmcapp.logic.dtos;

public class UsuarioDto extends BaseDto{

    public String username;
    public String tipo;
    public PersonaDto persona;


    public UsuarioDto(){

    }

    public UsuarioDto(long id) {
        super(id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "username='" + username + '\'' +
                ", tipo='" + tipo + '\'' +
                ", persona=" + persona +
                ", _id=" + _id +
                '}';
    }
}
