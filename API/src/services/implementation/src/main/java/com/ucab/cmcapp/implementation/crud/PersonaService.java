package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/persona")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaService extends CrudService<PersonaDto, Persona> {

    private static Logger _logger = LoggerFactory.getLogger( PersonaService.class );

    @Override
    protected UpdateEntityCommand<Persona> getCreateUpdateEntity(Persona entity) {
        return CommandFactory.createUpdatePersonaCommand(entity);
    }

    @Override
    protected CreateEntityCommand<Persona> getCreateCreateEntity(Persona entity) {
        return CommandFactory.createCreatePersonaCommand(entity);
    }

    @Override
    protected PersonaDto getDto(long id) {
        return new PersonaDto(id);
    }

    @Override
    protected GetEntitiesCommand<Persona> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetPersonasCommand(new DBHandler());
    }

    @Override
    protected GetEntityCommand<Persona> getCreateGetEntity(Persona entity) {
        return CommandFactory.createGetPersonaCommand(entity);
    }

    @Override
    protected BaseMapper<PersonaDto, Persona> getMapper() {
        return new PersonaMapper();
    }
}
