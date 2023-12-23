package com.ucab.cmcapp.logic.commands.persona.composite;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreatePersonaCommand extends CreateEntityCommand<Persona> {

    public CreatePersonaCommand(Persona entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<Persona> getAddCommand(Persona entity, DBHandler handler) {
        return CommandFactory.createAddPersonaCommand(entity, handler);
    }
}
