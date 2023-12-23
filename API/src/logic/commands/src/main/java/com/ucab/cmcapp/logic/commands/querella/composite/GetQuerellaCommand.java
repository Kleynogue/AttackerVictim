package com.ucab.cmcapp.logic.commands.querella.composite;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetQuerellaCommand extends GetEntityCommand<Querella> {
    public GetQuerellaCommand(Querella entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<Querella> getGetCommand(long id) {
        return CommandFactory.createGetQuerellaByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getQuerID();
    }
}
