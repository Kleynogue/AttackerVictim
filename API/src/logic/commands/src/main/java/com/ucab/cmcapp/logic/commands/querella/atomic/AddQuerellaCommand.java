package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddQuerellaCommand extends AddEntityCommand <Querella>{

    public AddQuerellaCommand(Querella entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddQuerellaCommand(Querella entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Querella> getDao(DBHandler handler) {
        return DaoFactory.createQuerellaDao(handler);
    }
}
