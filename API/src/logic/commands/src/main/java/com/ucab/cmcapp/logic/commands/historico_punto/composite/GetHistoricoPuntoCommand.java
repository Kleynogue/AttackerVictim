package com.ucab.cmcapp.logic.commands.historico_punto.composite;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetHistoricoPuntoCommand extends GetEntityCommand<HistoricoPunto> {
    public GetHistoricoPuntoCommand(HistoricoPunto entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<HistoricoPunto> getGetCommand(long id) {
        return CommandFactory.createGetHistoricoPuntoByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getHistPunID();
    }
}
