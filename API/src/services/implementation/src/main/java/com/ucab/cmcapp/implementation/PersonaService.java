package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonasCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/personas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( PersonaService.class );

    @GET
    public List<PersonaDto> getPersonas(){
        List<PersonaDto> response;
        GetPersonasCommand command = null;
        PersonaMapper mapper = new PersonaMapper();
        //region Instrumentation DEBUG
        _logger.debug( "Get in PersonaService.getPersonas" );
        //endregion

        try {
            command = CommandFactory.createGetPersonasCommand(new DBHandler());
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
            _logger.info( "Response getPersonas: {} ", response.toString());
        }catch (Exception e){
            _logger.error("error {} getting personas: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }finally {
            if(command != null)
                command.closeHandlerSession();
        }
        _logger.debug( "Leaving PersonaService.getPersonas" );
        return response;
    }
}
