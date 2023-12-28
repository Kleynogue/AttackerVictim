package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.common.exceptions.JsonValidationException;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.TelefonoMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Field;

@Path("/telefono")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TelefonoService extends CrudService<TelefonoDto, Telefono> {
    @Override
    protected UpdateEntityCommand<Telefono> getCreateUpdateEntity(Telefono entity) {
        return CommandFactory.createUpdateTelefonoCommand(entity);
    }

    @Override
    protected CreateEntityCommand<Telefono> getCreateCreateEntity(Telefono entity) {
        return CommandFactory.createCreateTelefonoCommand(entity);
    }

    @Override
    protected TelefonoDto getDto(long id) {
        return new TelefonoDto(id);
    }

    @Override
    protected GetEntitiesCommand<Telefono> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetTelefonosCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<Telefono> getCreateGetEntity(Telefono entity) {
        return CommandFactory.createGetTelefonoCommand(entity);
    }

    @Override
    protected BaseMapper<TelefonoDto, Telefono> getMapper() {
        return new TelefonoMapper();
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
