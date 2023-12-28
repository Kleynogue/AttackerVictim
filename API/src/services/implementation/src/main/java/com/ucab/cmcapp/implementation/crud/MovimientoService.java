package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.MovimientoDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.MovimientoMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/movimiento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovimientoService extends CrudService<MovimientoDto, Movimiento> {
    @Override
    protected UpdateEntityCommand<Movimiento> getCreateUpdateEntity(Movimiento entity) {
        return CommandFactory.createUpdateMovimientoCommand(entity);
    }

    @Override
    protected CreateEntityCommand<Movimiento> getCreateCreateEntity(Movimiento entity) {
        return CommandFactory.createCreateMovimientoCommand(entity);
    }

    @Override
    protected MovimientoDto getDto(long id) {
        return new MovimientoDto(id);
    }

    @Override
    protected GetEntitiesCommand<Movimiento> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetMovimientosCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<Movimiento> getCreateGetEntity(Movimiento entity) {
        return CommandFactory.createGetMovimientoCommand(entity);
    }

    @Override
    protected BaseMapper<MovimientoDto, Movimiento> getMapper() {
        return new MovimientoMapper();
    }
}
