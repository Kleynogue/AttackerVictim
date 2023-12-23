package com.ucab.cmcapp.logic.commands.punto_geografico.composite;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreatePuntoGeograficoCommand extends CreateEntityCommand<PuntoGeografico> {
    public CreatePuntoGeograficoCommand(PuntoGeografico entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<PuntoGeografico> getAddCommand(PuntoGeografico entity, DBHandler handler) {
        return CommandFactory.createAddPuntoGeograficoCommand(entity, handler);
    }
}
