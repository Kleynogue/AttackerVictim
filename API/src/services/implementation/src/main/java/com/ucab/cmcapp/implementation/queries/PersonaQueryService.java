package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByFullNameCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/query/persona")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaQueryService extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger( PersonaQueryService.class );

    @GET
    @RolesAllowed({"Administrador", "Victima"})
    public PersonaDto getPersonaByFullName(@QueryParam("name") String name,
                                           @QueryParam("lastname") String lastName)
    {
        PersonaDto response;
        Persona persona = new Persona();
        persona.setPersNombre(name);
        persona.setPersApellido(lastName);
        GetPersonaByFullNameCommand command;
        PersonaMapper mapper = new PersonaMapper();

        _logger.debug( "Get in PersonaQueryService.getPersonaByFullName" );

        try {
            command = CommandFactory.createGetPersonaByFullNameCommand(persona);
            command.execute();
            response = mapper.mapEntityToDto(command.getReturnParam());
        }catch (NotFoundException e){
            _logger.error("error {} getting persona {}: {}", e.getMessage(), name + " " + lastName, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.NOT_FOUND).
                    entity( e ).build() );
        }catch (Exception e){
            _logger.error("error {} getting persona {}: {}", e.getMessage(), name + " " + lastName, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving PersonaQueryService.getPersonaByFullName" );
        return response;
    }
}