package com.ucab.cmcapp.logic.commands.historico_punto.composite;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreateHistoricoPuntoCommand extends CreateEntityCommand<HistoricoPunto> {
    public CreateHistoricoPuntoCommand(HistoricoPunto entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<HistoricoPunto> getAddCommand(HistoricoPunto entity, DBHandler handler) {
        return CommandFactory.createAddHistoricoPuntoCommand(entity, handler);
    }
}
