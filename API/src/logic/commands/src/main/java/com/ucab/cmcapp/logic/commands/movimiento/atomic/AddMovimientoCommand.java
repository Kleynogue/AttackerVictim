package com.ucab.cmcapp.logic.commands.movimiento.atomic;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddMovimientoCommand extends AddEntityCommand<Movimiento> {
    public AddMovimientoCommand(Movimiento entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddMovimientoCommand(Movimiento entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Movimiento> getDao(DBHandler handler) {
        return DaoFactory.createMovimientoDao(handler);
    }
}
