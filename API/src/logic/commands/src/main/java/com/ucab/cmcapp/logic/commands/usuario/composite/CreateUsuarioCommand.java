package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;

import com.ucab.cmcapp.persistence.DBHandler;

public class CreateUsuarioCommand extends CreateEntityCommand<Usuario> {

    public CreateUsuarioCommand(Usuario entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<Usuario> getAddCommand(Usuario entity, DBHandler handler) {
        return CommandFactory.createAddUsuarioCommand(entity, handler);
    }
}
