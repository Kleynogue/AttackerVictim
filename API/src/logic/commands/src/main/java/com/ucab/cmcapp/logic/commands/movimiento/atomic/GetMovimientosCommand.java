package com.ucab.cmcapp.logic.commands.movimiento.atomic;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetMovimientosCommand extends GetEntitiesCommand<Movimiento> {


    public GetMovimientosCommand(DBHandler handler) {
        super(handler);
    }

    @Override
    protected BaseDao<Movimiento> getDao(DBHandler handler) {
        return DaoFactory.createMovimientoDao(handler);
    }

    @Override
    protected Class<Movimiento> obtainClass() {
        return Movimiento.class;
    }
}
