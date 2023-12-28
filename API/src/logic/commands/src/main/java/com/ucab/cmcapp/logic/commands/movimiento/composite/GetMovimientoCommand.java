package com.ucab.cmcapp.logic.commands.movimiento.composite;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetMovimientoCommand extends GetEntityCommand<Movimiento> {
    public GetMovimientoCommand(Movimiento entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<Movimiento> getGetCommand(long id) {
        return CommandFactory.createGetMovimientoByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getMoviID();
    }
}
