package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory

{
    public static Persona createPersona(){
        return new Persona();
    }

    public static Persona createPersona(long id){
        return new Persona(id);
    }

    public static Usuario createUsuario(){
        return new Usuario();
    }

    public static Usuario createUsuario(long id){
        return new Usuario(id);
    }

    public static Querella createQuerella(){
        return new Querella();
    }

    public static Querella createQuerella(long id){
        return new Querella(id);
    }

    public static Telefono createTelefono(){
        return new Telefono();
    }

    public static Telefono createTelefono(long id){
        return new Telefono(id);
    }

    public static ZonaSeguridad createZonaSeguridad(){
        return new ZonaSeguridad();
    }

    public static ZonaSeguridad createZonaSeguridad(long id){
        return new ZonaSeguridad(id);
    }

    public static PuntoGeografico createPuntoGeografico(){
        return new PuntoGeografico();
    }

    public static PuntoGeografico createPuntoGeografico(long id){
        return new PuntoGeografico(id);
    }

    public static Conexion createConexion(){
        return new Conexion();
    }

    public static Conexion createConexion(long id){
        return new Conexion(id);
    }

    public static Movimiento createMovimiento(){
        return new Movimiento();
    }

    public static Movimiento createMovimiento(long id){
        return new Movimiento(id);
    }

    public static Reporte createReporte(){
        return new Reporte();
    }

    public static Reporte createReporte(long id){
        return new Reporte(id);
    }

    public static HistoricoPunto createHistoricoPunto(){
        return new HistoricoPunto();
    }

    public static HistoricoPunto createHistoricoPunto(long id){
        return new HistoricoPunto(id);
    }

    public static ZonaPunto createZonaPunto(){
        return new ZonaPunto();
    }

    public static ZonaPunto createZonaPunto(PuntoGeografico pg, ZonaSeguridad zs){
        return new ZonaPunto(pg, zs);
    }


}
