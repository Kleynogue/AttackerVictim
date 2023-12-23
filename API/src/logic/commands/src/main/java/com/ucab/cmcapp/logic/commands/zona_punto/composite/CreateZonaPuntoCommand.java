package com.ucab.cmcapp.logic.commands.zona_punto.composite;

import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreateZonaPuntoCommand extends CreateEntityCommand<ZonaPunto> {
    public CreateZonaPuntoCommand(ZonaPunto entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<ZonaPunto> getAddCommand(ZonaPunto entity, DBHandler handler) {
        return CommandFactory.createAddZonaPuntoCommand(entity, handler);
    }
}
