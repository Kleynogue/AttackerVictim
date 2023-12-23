package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetQuerellasCommand extends GetEntitiesCommand<Querella> {

    public GetQuerellasCommand(DBHandler handler) {
        super(handler);
    }

    @Override
    protected BaseDao<Querella> getDao(DBHandler handler) {
        return DaoFactory.createQuerellaDao(handler);
    }

    @Override
    protected Class<Querella> obtainClass() {
        return Querella.class;
    }
}
