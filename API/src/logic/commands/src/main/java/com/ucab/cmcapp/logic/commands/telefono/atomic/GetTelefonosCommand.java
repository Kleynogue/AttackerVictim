package com.ucab.cmcapp.logic.commands.telefono.atomic;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetTelefonosCommand extends GetEntitiesCommand<Telefono> {


    public GetTelefonosCommand(DBHandler handler) {
        super(handler);
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
