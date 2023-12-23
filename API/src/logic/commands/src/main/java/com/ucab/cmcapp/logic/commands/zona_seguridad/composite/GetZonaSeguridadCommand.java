package com.ucab.cmcapp.logic.commands.zona_seguridad.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetZonaSeguridadCommand extends GetEntityCommand<ZonaSeguridad> {
    public GetZonaSeguridadCommand(ZonaSeguridad entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<ZonaSeguridad> getGetCommand(long id) {
        return CommandFactory.createGetZonaSeguridadByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getZonSegID();
    }
}
