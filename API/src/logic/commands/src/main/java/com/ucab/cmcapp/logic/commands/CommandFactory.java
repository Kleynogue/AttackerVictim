package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.conexion.atomic.*;
import com.ucab.cmcapp.logic.commands.conexion.composite.CreateConexionCommand;
import com.ucab.cmcapp.logic.commands.conexion.composite.GetConexionCommand;
import com.ucab.cmcapp.logic.commands.historico_punto.atomic.*;
import com.ucab.cmcapp.logic.commands.historico_punto.composite.CreateHistoricoPuntoCommand;
import com.ucab.cmcapp.logic.commands.historico_punto.composite.GetHistoricoPuntoCommand;
import com.ucab.cmcapp.logic.commands.movimiento.atomic.*;
import com.ucab.cmcapp.logic.commands.movimiento.composite.CreateMovimientoCommand;
import com.ucab.cmcapp.logic.commands.movimiento.composite.GetMovimientoCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.*;
import com.ucab.cmcapp.logic.commands.persona.composite.CreatePersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetPersonaCommand;
import com.ucab.cmcapp.logic.commands.punto_geografico.atomic.AddPuntoGeograficoCommand;
import com.ucab.cmcapp.logic.commands.punto_geografico.atomic.GetPuntoGeograficoByIdCommand;
import com.ucab.cmcapp.logic.commands.punto_geografico.atomic.GetPuntosGeograficosCommand;
import com.ucab.cmcapp.logic.commands.punto_geografico.atomic.UpdatePuntoGeograficoCommand;
import com.ucab.cmcapp.logic.commands.punto_geografico.composite.CreatePuntoGeograficoCommand;
import com.ucab.cmcapp.logic.commands.punto_geografico.composite.GetPuntoGeograficoCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.*;
import com.ucab.cmcapp.logic.commands.querella.composite.CreateQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetQuerellaCommand;
import com.ucab.cmcapp.logic.commands.reporte.atomic.*;
import com.ucab.cmcapp.logic.commands.reporte.composite.CreateReporteCommand;
import com.ucab.cmcapp.logic.commands.reporte.composite.GetReporteCommand;
import com.ucab.cmcapp.logic.commands.telefono.atomic.*;
import com.ucab.cmcapp.logic.commands.telefono.composite.CreateTelefonoCommand;
import com.ucab.cmcapp.logic.commands.telefono.composite.GetTelefonoCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.zona_punto.atomic.AddZonaPuntoCommand;
import com.ucab.cmcapp.logic.commands.zona_punto.atomic.GetPuntosByZonaCommand;
import com.ucab.cmcapp.logic.commands.zona_punto.atomic.GetZonasPuntoCommand;
import com.ucab.cmcapp.logic.commands.zona_punto.atomic.UpdateZonaPuntoCommand;
import com.ucab.cmcapp.logic.commands.zona_punto.composite.CreateZonaPuntoCommand;
import com.ucab.cmcapp.logic.commands.zona_seguridad.atomic.*;
import com.ucab.cmcapp.logic.commands.zona_seguridad.composite.CreateZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.zona_seguridad.composite.GetZonaSeguridadCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory {

    public static GetUserCommand createGetUserCommand(User user) {
        return new GetUserCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user) {
        return new GetUserByEmailCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user, DBHandler handler) {
        return new GetUserByEmailCommand(user, handler);
    }

    public static GetUserByIdCommand createGetUserByIdCommand(DBHandler handler, long userId) {
        return new GetUserByIdCommand(handler, userId);
    }

    public static AddUserCommand createAddUserCommand(User user, DBHandler handler) {
        return new AddUserCommand(user, handler);
    }

    public static AddUserCommand createAddUserCommand(User user) {
        return new AddUserCommand(user);
    }

    public static CreateUserCommand createCreateUserCommand(User user) {
        return new CreateUserCommand(user);
    }

    public static AddPersonaCommand createAddPersonaCommand(Persona persona) {
        return new AddPersonaCommand(persona);
    }

    public static AddPersonaCommand createAddPersonaCommand(Persona persona, DBHandler handler) {
        return new AddPersonaCommand(persona, handler);
    }

    public static GetPersonaByFullNameCommand createGetPersonaByFullNameCommand(Persona persona) {
        return new GetPersonaByFullNameCommand(persona);
    }

    public static GetPersonaByFullNameCommand createGetPersonaByFullNameCommand(Persona persona, DBHandler handler) {
        return new GetPersonaByFullNameCommand(persona, handler);
    }

    public static GetPersonaByIdCommand createGetPersonaByIdCommand(long id) {
        return new GetPersonaByIdCommand(id);
    }

    public static GetPersonaCommand createGetPersonaCommand(Persona persona){return new GetPersonaCommand(persona);}

    public static GetPersonasCommand createGetPersonasCommand(DBHandler handler){return new GetPersonasCommand(handler);}

    public static CreatePersonaCommand createCreatePersonaCommand(Persona persona){return new CreatePersonaCommand(persona);}

    public static UpdatePersonaCommand createUpdatePersonaCommand(Persona persona){return new UpdatePersonaCommand(persona);}

    public static AddUsuarioCommand createAddUsuarioCommand(Usuario usuario, DBHandler handler) {
        return new AddUsuarioCommand(usuario, handler);
    }

    public static GetUsuarioByIdCommand createGetUsuarioByIdCommand(long Id) {
        return new GetUsuarioByIdCommand(Id);
    }

    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuario usuario) {
        return new GetUsuarioByUsernameCommand(usuario);
    }

    public static GetUsuariosByTypeCommand createGetUsuariosByTypeCommand(String type) {
        return new GetUsuariosByTypeCommand(type);
    }

    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuario usuario) {
        return new CreateUsuarioCommand(usuario);
    }

    public static GetUsuarioCommand createGetUsuarioCommand(Usuario usuario) {
        return new GetUsuarioCommand(usuario);
    }

    public static GetUsuariosCommand createGetUsuariosCommand(DBHandler handler){return new GetUsuariosCommand(handler);}

    public static UpdateUsuarioCommand createUpdateUsuarioCommand(Usuario usuario){return new UpdateUsuarioCommand(usuario);}

    public static AddQuerellaCommand createAddQuerellaCommand(Querella entity, DBHandler handler) {
        return new AddQuerellaCommand(entity, handler);
    }

    public static GetQuerellaByIdCommand createGetQuerellaByIdCommand(long id) {
        return new GetQuerellaByIdCommand(id);
    }

    public static CreateQuerellaCommand createCreateQuerellaCommand(Querella querella) {
        return new CreateQuerellaCommand(querella);
    }

    public static GetQuerellaCommand createGetQuerellaCommand(Querella querella) {
        return new GetQuerellaCommand(querella);
    }

    public static GetQuerellasByStatusCommand createGetQuerellasByStatusCommand(Querella querella) {
        return new GetQuerellasByStatusCommand(querella);
    }

    public static GetQuerellasCommand createGetQuerellasCommand(DBHandler handler){return new GetQuerellasCommand(handler);}

    public static UpdateQuerellaCommand createUpdateQuerellaCommand(Querella querella){return new UpdateQuerellaCommand(querella);}

    public static GetTelefonoByIdCommand createGetTelefonoByIdCommand(long id) {return new GetTelefonoByIdCommand(id);}

    public static AddTelefonoCommand createAddTelefonoCommand(Telefono entity, DBHandler handler) {return new AddTelefonoCommand(entity, handler);}

    public static GetTelefonoByBluetoothCommand createGetTelefonoByBluetoothCommand(Telefono telefono){return new GetTelefonoByBluetoothCommand(telefono);}

    public static CreateTelefonoCommand createCreateTelefonoCommand(Telefono telefono){return new CreateTelefonoCommand(telefono);}

    public static GetTelefonoCommand createGetTelefonoCommand(Telefono telefono){return new GetTelefonoCommand(telefono);}

    public static GetTelefonosCommand createGetTelefonosCommand(DBHandler handler){return new GetTelefonosCommand(handler);}

    public static UpdateTelefonoCommand createUpdateTelefonoCommand(Telefono telefono){return new UpdateTelefonoCommand(telefono);}

    public static GetTelefonosByQuerellaCommand createGetTelefonosByQuerellaCommand(Telefono telefono){return new GetTelefonosByQuerellaCommand(telefono);}

    public static AddZonaSeguridadCommand createAddZonaSeguridadCommand(ZonaSeguridad entity, DBHandler handler) {return new AddZonaSeguridadCommand(entity, handler);}

    public static GetZonaSeguridadByIdCommand createGetZonaSeguridadByIdCommand(long id) {return new GetZonaSeguridadByIdCommand(id);}

    public static GetZonaSeguridadByNameCommand createGetZonaSeguridadByNameCommand(ZonaSeguridad zs){return new GetZonaSeguridadByNameCommand(zs);}

    public static CreateZonaSeguridadCommand createCreateZonaSeguridadCommand(ZonaSeguridad zs){return new CreateZonaSeguridadCommand(zs);}

    public static GetZonaSeguridadCommand createGetZonaSeguridadCommand(ZonaSeguridad zs){return new GetZonaSeguridadCommand(zs);}

    public static GetZonasSeguridadCommand createGetZonasSeguridadCommand(DBHandler handler){return new GetZonasSeguridadCommand(handler);}

    public static UpdateZonaSeguridadCommand createUpdateZonaSeguridadCommand(ZonaSeguridad zs){return new UpdateZonaSeguridadCommand(zs);}

    public static GetZonasSeguridadByQuerellaCommand createGetZonasSeguridadByQuerellaCommand(ZonaSeguridad zs){return new GetZonasSeguridadByQuerellaCommand(zs);}

    public static AddPuntoGeograficoCommand createAddPuntoGeograficoCommand(PuntoGeografico entity, DBHandler handler) {return new AddPuntoGeograficoCommand(entity, handler);}

    public static GetPuntoGeograficoByIdCommand createGetPuntoGeograficoByIdCommand(long id) {return new GetPuntoGeograficoByIdCommand(id);}

    public static CreatePuntoGeograficoCommand createCreatePuntoGeograficoCommand(PuntoGeografico punto){return new CreatePuntoGeograficoCommand(punto);}

    public static GetPuntoGeograficoCommand createGetPuntoGeograficoCommand(PuntoGeografico punto){return new GetPuntoGeograficoCommand(punto);}

    public static GetPuntosGeograficosCommand createGetPuntosGeograficosCommand(DBHandler handler){return new GetPuntosGeograficosCommand(handler);}

    public static UpdatePuntoGeograficoCommand createUpdatePuntoGeograficoCommand(PuntoGeografico pg){return new UpdatePuntoGeograficoCommand(pg);}

    public static AddEntityCommand<Conexion> createAddConexionCommad(Conexion entity, DBHandler handler) {return new AddConexionCommand(entity, handler);}

    public static GetEntityByIdCommand<Conexion> createGetConexionByIdCommand(long id) {return new GetConexionByIdCommand(id);}

    public static CreateConexionCommand createCreateConexionCommand(Conexion conexion){return new CreateConexionCommand(conexion);}

    public static GetConexionCommand createGetConexionCommand(Conexion conexion){return new GetConexionCommand(conexion);}

    public static GetConnectionsByDateCommand createGetConnectionsByDateCommand(Conexion conexion){return new GetConnectionsByDateCommand(conexion);}

    public static GetConexionesCommand createGetConexionesCommand(DBHandler handler){return new GetConexionesCommand(handler);}

    public static UpdateConexionCommand createUpdateConexionCommand(Conexion conexion){return new UpdateConexionCommand(conexion);}

    public static GetConnectionsByPhoneCommand createGetConnectionsByPhoneCommand(Conexion conexion){return new GetConnectionsByPhoneCommand(conexion);}

    public static AddMovimientoCommand createAddMovimientoCommand(Movimiento entity, DBHandler handler) {return new AddMovimientoCommand(entity, handler);}

    public static GetMovimientoByIdCommand createGetMovimientoByIdCommand(long id) {return new GetMovimientoByIdCommand(id);}

    public static CreateMovimientoCommand createCreateMovimientoCommand(Movimiento movimiento){return new CreateMovimientoCommand(movimiento);}

    public static GetMovimientoCommand createGetMovimientoCommand(Movimiento movimiento){return new GetMovimientoCommand(movimiento);}

    public static GetMovesByDateCommand createGetMovesByDateCommand(Movimiento movimiento){return new GetMovesByDateCommand(movimiento);}

    public static GetMovimientosCommand createGetMovimientosCommand(DBHandler handler){return new GetMovimientosCommand(handler);}

    public static UpdateMovimientoCommand createUpdateMovimientoCommand(Movimiento movimiento){return new UpdateMovimientoCommand(movimiento);}

    public static GetMovesByPhoneCommand createGetMovesByPhoneCommand(Movimiento movimiento){return new GetMovesByPhoneCommand(movimiento);}

    public static AddReporteCommand createAddReporteCommand(Reporte entity, DBHandler handler) {return new AddReporteCommand(entity, handler);}

    public static GetReporteByIdCommand createGetReporteByIdCommand(long id) {return new GetReporteByIdCommand(id);}

    public static CreateReporteCommand createCreateReporteCommand(Reporte reporte){return new CreateReporteCommand(reporte);}

    public static GetReporteCommand createGetReporteCommand(Reporte reporte){return new GetReporteCommand(reporte);}

    public static GetReportsByPhoneCommand createGetReportsByPhoneCommand(Reporte reporte){return new GetReportsByPhoneCommand(reporte);}

    public static GetReportsByDateCommand createGetReportsByDateCommand(Reporte reporte){return new GetReportsByDateCommand(reporte);}

    public static GetReportesCommand createGetReportesCommand(DBHandler handler){return new GetReportesCommand(handler);}

    public static UpdateReporteCommand createUpdateReporteCommand(Reporte reporte){return new UpdateReporteCommand(reporte);}

    public static AddHistoricoPuntoCommand createAddHistoricoPuntoCommand(HistoricoPunto entity, DBHandler handler) {return new AddHistoricoPuntoCommand(entity, handler);}

    public static GetHistoricoPuntoByIdCommand createGetHistoricoPuntoByIdCommand(long id) {return new GetHistoricoPuntoByIdCommand(id);}

    public static CreateHistoricoPuntoCommand createCreateHistoricoPuntoCommand(HistoricoPunto historico){return new CreateHistoricoPuntoCommand(historico);}

    public static GetHistoricoPuntoCommand createGetHistoricoPuntoCommand(HistoricoPunto historico){return new GetHistoricoPuntoCommand(historico);}

    public static GetHistoryByPhoneCommand createGetHistoryByPhoneCommand(HistoricoPunto historico){return new GetHistoryByPhoneCommand(historico);}

    public static GetHistoricosPuntoCommand createGetHistoricosPuntoCommand(DBHandler handler){return new GetHistoricosPuntoCommand(handler);}

    public static UpdateHistoricoPuntoCommand createUpdateHistoricoPuntoCommand(HistoricoPunto hp){return new UpdateHistoricoPuntoCommand(hp);}

    public static AddEntityCommand<ZonaPunto> createAddZonaPuntoCommand(ZonaPunto entity, DBHandler handler) {return new AddZonaPuntoCommand(entity, handler);}

    public static GetPuntosByZonaCommand createGetPuntosByZonaCommand(ZonaPunto zp) {return new GetPuntosByZonaCommand(zp);
    }

    public static CreateZonaPuntoCommand createCreateZonaPuntoCommand(ZonaPunto zp){return new CreateZonaPuntoCommand(zp);}

    public static GetZonasPuntoCommand createGetZonasPuntoCommand(DBHandler handler){return new GetZonasPuntoCommand(handler);}

    public static UpdateZonaPuntoCommand createUpdateZonaPuntoCommand(ZonaPunto zp){return new UpdateZonaPuntoCommand(zp);}
}