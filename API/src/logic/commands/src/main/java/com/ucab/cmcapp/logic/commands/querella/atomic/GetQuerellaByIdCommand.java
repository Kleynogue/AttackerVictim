package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetQuerellaByIdCommand extends GetEntityByIdCommand<Querella> {
    public GetQuerellaByIdCommand(long Id) {
        super(Id);
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
