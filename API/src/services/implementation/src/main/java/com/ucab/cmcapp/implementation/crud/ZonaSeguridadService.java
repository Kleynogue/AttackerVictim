package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/zona-seguridad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZonaSeguridadService extends CrudService<ZonaSeguridadDto, ZonaSeguridad> {
    @Override
    protected UpdateEntityCommand<ZonaSeguridad> getCreateUpdateEntity(ZonaSeguridad entity) {
        return CommandFactory.createUpdateZonaSeguridadCommand(entity);
    }

    @Override
    protected CreateEntityCommand<ZonaSeguridad> getCreateCreateEntity(ZonaSeguridad entity) {
        return CommandFactory.createCreateZonaSeguridadCommand(entity);
    }

    @Override
    protected ZonaSeguridadDto getDto(long id) {
        return new ZonaSeguridadDto(id);
    }

    @Override
    protected GetEntitiesCommand<ZonaSeguridad> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetZonasSeguridadCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<ZonaSeguridad> getCreateGetEntity(ZonaSeguridad entity) {
        return CommandFactory.createGetZonaSeguridadCommand(entity);
    }

    @Override
    protected BaseMapper<ZonaSeguridadDto, ZonaSeguridad> getMapper() {
        return new ZonaSeguridadMapper();
    }
}
