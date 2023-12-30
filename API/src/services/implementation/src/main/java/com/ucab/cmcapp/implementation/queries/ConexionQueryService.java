package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.GetConnectionsByDateCommand;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.ConexionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/query/conexion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConexionQueryService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( ConexionQueryService.class );

    @GET
    public List<ConexionDto> getConnectionsByDate(@QueryParam("date") String date){
        List<ConexionDto> response;
        Conexion conexion = new Conexion();
        GetConnectionsByDateCommand command;
        ConexionMapper mapper = new ConexionMapper();

        _logger.debug( "Get in ConexionQueryService.getConnectionsByDate" );

        try {
            conexion.setConeFecha(BaseMapper.parseStringToDate(date));
            command = CommandFactory.createGetConnectionsByDateCommand(conexion);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting conexiones {}: {}", e.getMessage(), date, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ConexionQueryService.getConnectionsByDate" );
        return response;
    }

}
