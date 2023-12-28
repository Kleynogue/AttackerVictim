package com.ucab.cmcapp.logic.commands.telefono.atomic;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateTelefonoCommand extends UpdateEntityCommand<Telefono> {
    public UpdateTelefonoCommand(Telefono entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateTelefonoCommand(Telefono entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Telefono> getDao(DBHandler handler) {
        return DaoFactory.createTelefonoDao(handler);
    }
}
