package com.ucab.cmcapp.logic.commands.querella.composite;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreateQuerellaCommand extends CreateEntityCommand<Querella> {
    public CreateQuerellaCommand(Querella entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<Querella> getAddCommand(Querella entity, DBHandler handler) {
        return CommandFactory.createAddQuerellaCommand(entity, handler);
    }
}
