package com.ucab.cmcapp.logic.commands.reporte.composite;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreateReporteCommand extends CreateEntityCommand<Reporte> {
    public CreateReporteCommand(Reporte entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<Reporte> getAddCommand(Reporte entity, DBHandler handler) {
        return CommandFactory.createAddReporteCommand(entity, handler);
    }
}
