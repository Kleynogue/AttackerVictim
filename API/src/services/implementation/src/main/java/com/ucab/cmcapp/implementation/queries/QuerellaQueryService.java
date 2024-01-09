package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.querella.atomic.GetQuerellasByStatusCommand;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;
import com.ucab.cmcapp.logic.mappers.QuerellaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/query/querella")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuerellaQueryService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( QuerellaQueryService.class );

    @GET
    @RolesAllowed({"Administrador"})
    public List<QuerellaDto> getQuerellasByStatus(@QueryParam("status") String status){

        List<QuerellaDto> response;
        Querella querella = new Querella();
        querella.setQuerStatus(status);
        GetQuerellasByStatusCommand command;
        QuerellaMapper mapper = new QuerellaMapper();

        _logger.debug( "Get in QuerellaQueryService.getQuerellasByStatus" );

        try {
            command = CommandFactory.createGetQuerellasByStatusCommand(querella);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (NotFoundException e){
            _logger.error("error {} getting querellas {}: {}", e.getMessage(), status, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.NOT_FOUND ).
                    entity( e ).build() );
        }catch (Exception e){
            _logger.error("error {} getting querellas {}: {}", e.getMessage(), status, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving QuerellaQueryService.getQuerellasByStatus" );
        return response;

    }

}
