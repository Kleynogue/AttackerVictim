package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetUsuarioCommand extends GetEntityCommand<Usuario> {

    public GetUsuarioCommand(Usuario entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<Usuario> getGetCommand(long id) {
        return CommandFactory.createGetUsuarioByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getUsuaID();
    }
}
