package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.QuerellaMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/querella")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuerellaService extends CrudService<QuerellaDto, Querella> {
    @Override
    protected UpdateEntityCommand<Querella> getCreateUpdateEntity(Querella entity) {
        return CommandFactory.createUpdateQuerellaCommand(entity);
    }

    @Override
    protected CreateEntityCommand<Querella> getCreateCreateEntity(Querella entity) {
        return CommandFactory.createCreateQuerellaCommand(entity);
    }

    @Override
    protected QuerellaDto getDto(long id) {
        return new QuerellaDto(id);
    }

    @Override
    protected GetEntitiesCommand<Querella> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetQuerellasCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<Querella> getCreateGetEntity(Querella entity) {
        return CommandFactory.createGetQuerellaCommand(entity);
    }

    @Override
    protected BaseMapper<QuerellaDto, Querella> getMapper() {
        return new QuerellaMapper();
    }
}
