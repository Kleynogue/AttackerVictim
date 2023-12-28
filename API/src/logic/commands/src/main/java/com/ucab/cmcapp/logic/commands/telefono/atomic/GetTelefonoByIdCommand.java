package com.ucab.cmcapp.logic.commands.telefono.atomic;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetTelefonoByIdCommand extends GetEntityByIdCommand<Telefono> {
    public GetTelefonoByIdCommand(long Id) {
        super(Id);
    }

    @Override
    protected BaseDao<Telefono> getDao(DBHandler handler) {
        return DaoFactory.createTelefonoDao(handler);
    }

    @Override
    protected Class<Telefono> obtainClass() {
        return Telefono.class;
    }
}
