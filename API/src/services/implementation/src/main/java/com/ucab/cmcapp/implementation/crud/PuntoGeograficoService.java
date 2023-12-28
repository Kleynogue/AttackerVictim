package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.PuntoGeograficoDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.PuntoGeograficoMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/punto-geografico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PuntoGeograficoService extends CrudService<PuntoGeograficoDto, PuntoGeografico> {
    @Override
    protected UpdateEntityCommand<PuntoGeografico> getCreateUpdateEntity(PuntoGeografico entity) {
        return CommandFactory.createUpdatePuntoGeograficoCommand(entity);
    }

    @Override
    protected CreateEntityCommand<PuntoGeografico> getCreateCreateEntity(PuntoGeografico entity) {
        return CommandFactory.createCreatePuntoGeograficoCommand(entity);
    }

    @Override
    protected PuntoGeograficoDto getDto(long id) {
        return new PuntoGeograficoDto(id);
    }

    @Override
    protected GetEntitiesCommand<PuntoGeografico> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetPuntosGeograficosCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<PuntoGeografico> getCreateGetEntity(PuntoGeografico entity) {
        return CommandFactory.createGetPuntoGeograficoCommand(entity);
    }

    @Override
    protected BaseMapper<PuntoGeograficoDto, PuntoGeografico> getMapper() {
        return new PuntoGeograficoMapper();
    }
}
