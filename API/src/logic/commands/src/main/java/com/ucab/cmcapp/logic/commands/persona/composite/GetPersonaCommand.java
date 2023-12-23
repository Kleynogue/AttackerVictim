package com.ucab.cmcapp.logic.commands.persona.composite;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetPersonaCommand extends GetEntityCommand<Persona> {

    public GetPersonaCommand(Persona entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<Persona> getGetCommand(long id) {
        return CommandFactory.createGetPersonaByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getPersID();
    }
}
