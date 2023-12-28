package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateQuerellaCommand extends UpdateEntityCommand<Querella> {
    public UpdateQuerellaCommand(Querella entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateQuerellaCommand(Querella entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Querella> getDao(DBHandler handler) {
        return DaoFactory.createQuerellaDao(handler);
    }
}
