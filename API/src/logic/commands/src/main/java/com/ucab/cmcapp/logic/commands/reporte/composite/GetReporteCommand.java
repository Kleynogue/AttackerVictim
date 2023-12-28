package com.ucab.cmcapp.logic.commands.reporte.composite;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetReporteCommand extends GetEntityCommand<Reporte> {
    public GetReporteCommand(Reporte entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<Reporte> getGetCommand(long id) {
        return CommandFactory.createGetReporteByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getRepoID();
    }
}
