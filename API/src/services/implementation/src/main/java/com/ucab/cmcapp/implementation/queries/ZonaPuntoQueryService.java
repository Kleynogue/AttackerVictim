package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zona_punto.atomic.GetPuntosByZonaCommand;
import com.ucab.cmcapp.logic.dtos.ZonaPuntoDto;
import com.ucab.cmcapp.logic.mappers.ZonaPuntoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/query/zona-punto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZonaPuntoQueryService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( ZonaPuntoQueryService.class );

    @GET
    public List<ZonaPuntoDto> getPuntosByZona(@QueryParam("zona") long zonaID){

        List<ZonaPuntoDto> response;
        ZonaPunto zonaPunto = new ZonaPunto();
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad(zonaID);
        ZonaPuntoMapper mapper = new ZonaPuntoMapper();
        GetPuntosByZonaCommand command;
        zonaPunto.setZonPunFKZonaSeguridad(zonaSeguridad);

        _logger.debug( "Get in ZonaPuntaQueryService.getPuntosByZona" );

        try {
            command = CommandFactory.createGetPuntosByZonaCommand(zonaPunto);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting puntos in zona {}: {}", e.getMessage(), zonaID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ZonaPuntaQueryService.getPuntosByZona" );
        return response;

    }


}
