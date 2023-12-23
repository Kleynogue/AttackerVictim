package com.ucab.cmcapp.logic.commands.telefono.composite;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreateTelefonoCommand extends CreateEntityCommand<Telefono> {
    public CreateTelefonoCommand(Telefono entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<Telefono> getAddCommand(Telefono entity, DBHandler handler) {
        return CommandFactory.createAddTelefonoCommand(entity, handler);
    }
}
