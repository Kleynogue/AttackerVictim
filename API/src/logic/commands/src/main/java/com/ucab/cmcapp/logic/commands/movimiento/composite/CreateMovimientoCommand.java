package com.ucab.cmcapp.logic.commands.movimiento.composite;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreateMovimientoCommand extends CreateEntityCommand<Movimiento> {
    public CreateMovimientoCommand(Movimiento entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<Movimiento> getAddCommand(Movimiento entity, DBHandler handler) {
        return CommandFactory.createAddMovimientoCommand(entity, handler);
    }
}
