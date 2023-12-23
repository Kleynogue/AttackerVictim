package com.ucab.cmcapp.logic.commands.zona_seguridad.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreateZonaSeguridadCommand extends CreateEntityCommand<ZonaSeguridad> {
    public CreateZonaSeguridadCommand(ZonaSeguridad entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<ZonaSeguridad> getAddCommand(ZonaSeguridad entity, DBHandler handler) {
        return CommandFactory.createAddZonaSeguridadCommand(entity, handler);
    }
}
