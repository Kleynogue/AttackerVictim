package com.ucab.cmcapp.logic.commands.telefono.atomic;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddTelefonoCommand extends AddEntityCommand<Telefono> {
    public AddTelefonoCommand(Telefono entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddTelefonoCommand(Telefono entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Telefono> getDao(DBHandler handler) {
        return DaoFactory.createTelefonoDao(handler);
    }
}
