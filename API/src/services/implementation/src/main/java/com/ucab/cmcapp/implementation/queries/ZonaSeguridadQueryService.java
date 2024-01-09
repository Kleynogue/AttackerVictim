package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.reporte.atomic.GetReportsByPhoneCommand;
import com.ucab.cmcapp.logic.commands.zona_seguridad.atomic.GetZonaSeguridadByNameCommand;
import com.ucab.cmcapp.logic.commands.zona_seguridad.atomic.GetZonasSeguridadByQuerellaCommand;
import com.ucab.cmcapp.logic.dtos.ReporteDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.ReporteMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/query/zona-seguridad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZonaSeguridadQueryService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadQueryService.class );

    @Path("/1")
    @GET
    @RolesAllowed({"Administrador", "Victima"})
    public List<ZonaSeguridadDto> getZonaSeguridadByName(@QueryParam("name") String name){
        List<ZonaSeguridadDto> response;
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        ZonaSeguridadMapper mapper = new ZonaSeguridadMapper();
        GetZonaSeguridadByNameCommand command;
        zonaSeguridad.setZonSegNombre(name);


        _logger.debug( "Get in ZonaSeguridadQueryService.getZonaSeguridadByName" );

        try {
            command = CommandFactory.createGetZonaSeguridadByNameCommand(zonaSeguridad);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (NotFoundException e){
            _logger.error("error {} getting zona seguridad {}: {}", e.getMessage(), name, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.NOT_FOUND ).
                    entity( e ).build() );
        }
        catch (Exception e){
            _logger.error("error {} getting zona seguridad {}: {}", e.getMessage(), name, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ZonaSeguridadQueryService.getZonaSeguridadByName" );
        return response;
    }

    @Path("/2")
    @GET
    @RolesAllowed({"Administrador", "Victima"})
    public List<ZonaSeguridadDto> getZonasSeguridadByQuerella(@QueryParam("querella") long querellaID){

        List<ZonaSeguridadDto> response;
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        Querella querella = new Querella(querellaID);
        ZonaSeguridadMapper mapper = new ZonaSeguridadMapper();
        GetZonasSeguridadByQuerellaCommand command;
        zonaSeguridad.setZonSegFKQuerella(querella);

        _logger.debug( "Get in ZonaSeguridadQueryService.getZonasSeguridadByQuerells" );

        try {

            command = CommandFactory.createGetZonasSeguridadByQuerellaCommand(zonaSeguridad);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (NotFoundException e){
            _logger.error("error {} getting zonas de seguridad of querella {}: {}", e.getMessage(), querellaID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.NOT_FOUND ).
                    entity( e ).build() );
        }catch (Exception e){
            _logger.error("error {} getting zonas de seguridad of querella {}: {}", e.getMessage(), querellaID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ZonaSeguridadQueryService.getZonasSeguridadByQuerells" );
        return response;
    }

}
