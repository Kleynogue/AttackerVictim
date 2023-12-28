package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioService extends CrudService<UsuarioDto, Usuario> {

    @Override
    protected UpdateEntityCommand<Usuario> getCreateUpdateEntity(Usuario entity) {
        return CommandFactory.createUpdateUsuarioCommand(entity);
    }

    @Override
    protected CreateEntityCommand<Usuario> getCreateCreateEntity(Usuario entity) {
        return CommandFactory.createCreateUsuarioCommand(entity);
    }

    @Override
    protected UsuarioDto getDto(long id) {
        return new UsuarioDto(id);
    }

    @Override
    protected GetEntitiesCommand<Usuario> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetUsuariosCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<Usuario> getCreateGetEntity(Usuario entity) {
        return CommandFactory.createGetUsuarioCommand(entity);
    }

    @Override
    protected BaseMapper<UsuarioDto, Usuario> getMapper() {
        return new UsuarioMapper();
    }
}
