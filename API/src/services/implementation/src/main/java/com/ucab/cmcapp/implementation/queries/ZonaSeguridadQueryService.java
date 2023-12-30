package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zona_seguridad.atomic.GetZonaSeguridadByNameCommand;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/query/zona-seguridad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZonaSeguridadQueryService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadQueryService.class );

    @GET
    public ZonaSeguridadDto getZonaSeguridadByName(@QueryParam("name") String name){
        ZonaSeguridadDto response;
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.setZonSegNombre(name);
        GetZonaSeguridadByNameCommand command;
        ZonaSeguridadMapper mapper = new ZonaSeguridadMapper();

        _logger.debug( "Get in ZonaSeguridadQueryService.getZonaSeguridadByName" );

        try {
            command = CommandFactory.createGetZonaSeguridadByNameCommand(zonaSeguridad);
            command.execute();
            response = mapper.mapEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting zona seguridad {}: {}", e.getMessage(), name, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ZonaSeguridadQueryService.getZonaSeguridadByName" );
        return response;
    }

}
