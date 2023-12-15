package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory
{
    private DaoFactory() {}

    public static UserDao createUserDao( DBHandler handler )
    {
        return new UserDao( handler );
    }

    public static PersonaDao createPersonaDao( DBHandler handler) { return new PersonaDao(handler);}

    public static UsuarioDao createUsuarioDao( DBHandler handler ) { return new UsuarioDao(handler);}

    public static QuerellaDao createQuerellaDao( DBHandler handler) { return new QuerellaDao(handler);}

    public static TelefonoDao createTelefonoDao( DBHandler handler) { return new TelefonoDao(handler);}

    public static ZonaSeguridadDao createZonaSeguridadDao ( DBHandler handler ) { return new ZonaSeguridadDao(handler);}

    public static ConexionDao createConexionDao ( DBHandler handler ) { return new ConexionDao(handler);}

    public static MovimientoDao createMovimientoDao ( DBHandler handler ) { return new MovimientoDao(handler);}

    public static ReporteDao createReporteDao ( DBHandler handler ) { return new ReporteDao(handler);}

    public static HistoricoPuntoDao createHistoricoPuntoDao ( DBHandler handler ) { return new HistoricoPuntoDao(handler);}

    public static ZonaPuntoDao createZonaPuntoDao ( DBHandler handler ) { return new ZonaPuntoDao(handler);}

}
