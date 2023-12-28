package com.ucab.cmcapp.logic.commands.movimiento.atomic;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateMovimientoCommand extends UpdateEntityCommand<Movimiento> {
    public UpdateMovimientoCommand(Movimiento entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateMovimientoCommand(Movimiento entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Movimiento> getDao(DBHandler handler) {
        return DaoFactory.createMovimientoDao(handler);
    }
}
