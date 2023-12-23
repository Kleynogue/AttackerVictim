package com.ucab.cmcapp.logic.commands.telefono.composite;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetTelefonoCommand extends GetEntityCommand<Telefono>{
    public GetTelefonoCommand(Telefono entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<Telefono> getGetCommand(long id) {
        return CommandFactory.createGetTelefonoByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getTeleID();
    }
}
