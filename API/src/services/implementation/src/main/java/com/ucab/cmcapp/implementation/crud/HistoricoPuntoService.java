package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.common.exceptions.JsonValidationException;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.HistoricoPuntoDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.HistoricoPuntoMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Field;

@Path("/historico-punto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoricoPuntoService extends CrudService<HistoricoPuntoDto, HistoricoPunto> {
    @Override
    protected UpdateEntityCommand<HistoricoPunto> getCreateUpdateEntity(HistoricoPunto entity) {
        return CommandFactory.createUpdateHistoricoPuntoCommand(entity);
    }

    @Override
    protected CreateEntityCommand<HistoricoPunto> getCreateCreateEntity(HistoricoPunto entity) {
        return CommandFactory.createCreateHistoricoPuntoCommand(entity);
    }

    @Override
    protected HistoricoPuntoDto getDto(long id) {
        return new HistoricoPuntoDto(id);
    }

    @Override
    protected GetEntitiesCommand<HistoricoPunto> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetHistoricosPuntoCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<HistoricoPunto> getCreateGetEntity(HistoricoPunto entity) {
        return CommandFactory.createGetHistoricoPuntoCommand(entity);
    }

    @Override
    protected BaseMapper<HistoricoPuntoDto, HistoricoPunto> getMapper() {
        return new HistoricoPuntoMapper();
    }

    @Override
    protected void validateFields(Object obj) throws IllegalAccessException, JsonValidationException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (value == null && !field.getName().equals("fechaFin")) {
                throw new JsonValidationException("Field '" + field.getName() + "' has a null value.");
            }
        }
    }
}
