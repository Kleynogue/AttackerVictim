package com.ucab.cmcapp.logic.commands.punto_geografico.composite;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetPuntoGeograficoCommand extends GetEntityCommand<PuntoGeografico> {
    public GetPuntoGeograficoCommand(PuntoGeografico entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<PuntoGeografico> getGetCommand(long id) {
        return CommandFactory.createGetPuntoGeograficoByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getPunGeoID();
    }
}
