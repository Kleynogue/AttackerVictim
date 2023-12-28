package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.ZonaPuntoDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.ZonaPuntoMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/zona-punto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZonaPuntoService extends CrudService<ZonaPuntoDto, ZonaPunto> {

    @Override
    public ZonaPuntoDto getEntity(long id) {
        return new ZonaPuntoDto(1);
    }

    @Override
    protected UpdateEntityCommand<ZonaPunto> getCreateUpdateEntity(ZonaPunto entity) {
        return CommandFactory.createUpdateZonaPuntoCommand(entity);
    }

    @Override
    protected CreateEntityCommand<ZonaPunto> getCreateCreateEntity(ZonaPunto entity) {
        return CommandFactory.createCreateZonaPuntoCommand(entity);
    }

    @Override
    protected ZonaPuntoDto getDto(long id) {
        return new ZonaPuntoDto(id);
    }

    @Override
    protected GetEntitiesCommand<ZonaPunto> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetZonasPuntoCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<ZonaPunto> getCreateGetEntity(ZonaPunto entity) {
        return null;
    }

    @Override
    protected BaseMapper<ZonaPuntoDto, ZonaPunto> getMapper() {
        return new ZonaPuntoMapper();
    }
}
