package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.ConexionMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/conexion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConexionService extends CrudService<ConexionDto, Conexion> {
    @Override
    protected UpdateEntityCommand<Conexion> getCreateUpdateEntity(Conexion entity) {
        return CommandFactory.createUpdateConexionCommand(entity);
    }

    @Override
    protected CreateEntityCommand<Conexion> getCreateCreateEntity(Conexion entity) {
        return CommandFactory.createCreateConexionCommand(entity);
    }

    @Override
    protected ConexionDto getDto(long id) {
        return new ConexionDto(id);
    }

    @Override
    protected GetEntitiesCommand<Conexion> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetConexionesCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<Conexion> getCreateGetEntity(Conexion entity) {
        return CommandFactory.createGetConexionCommand(entity);
    }

    @Override
    protected BaseMapper<ConexionDto, Conexion> getMapper() {
        return new ConexionMapper();
    }
}
