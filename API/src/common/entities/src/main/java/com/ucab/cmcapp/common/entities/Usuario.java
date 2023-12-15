package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "Usua_ID")
    private long usuaID;

    @Column(name = "Usua_Username")
    private String usuaUsername;

    @Column(name = "Usua_Contrasena")
    private String usuaContrasena;

    @Column(name = "Usua_Tipo")
    private String usuaTipo;

    @OneToOne
    @JoinColumn(name = "Usua_FK_Persona")
    private Persona usuaFKPersona;


    public Usuario(){

    }

    public Usuario(long usuaID) {
        this.usuaID = usuaID;
    }

    public long getUsuaID() {
        return usuaID;
    }

    public void setUsuaID(long usuaID) {
        this.usuaID = usuaID;
    }

    public String getUsuaUsername() {
        return usuaUsername;
    }

    public void setUsuaUsername(String usuaUsername) {
        this.usuaUsername = usuaUsername;
    }

    public String getUsuaContrasena() {
        return usuaContrasena;
    }

    public void setUsuaContrasena(String usuaContrasena) {
        this.usuaContrasena = usuaContrasena;
    }

    public String getUsuaTipo() {
        return usuaTipo;
    }

    public void setUsuaTipo(String usuaTipo) {
        this.usuaTipo = usuaTipo;
    }

    public Persona getUsuaFKPersona() {
        return usuaFKPersona;
    }

    public void setUsuaFKPersona(Persona usuaFKPersona) {
        this.usuaFKPersona = usuaFKPersona;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuaID=" + usuaID +
                ", usuaUsername='" + usuaUsername + '\'' +
                ", usuaContrasena='" + usuaContrasena + '\'' +
                ", usuaTipo='" + usuaTipo + '\'' +
                ", usuaFKPersona=" + usuaFKPersona +
                '}';
    }
}
