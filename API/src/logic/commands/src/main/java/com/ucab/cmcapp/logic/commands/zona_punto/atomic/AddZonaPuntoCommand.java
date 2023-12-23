package com.ucab.cmcapp.logic.commands.zona_punto.atomic;

import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddZonaPuntoCommand extends AddEntityCommand<ZonaPunto> {
    public AddZonaPuntoCommand(ZonaPunto entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddZonaPuntoCommand(ZonaPunto entity) {
        super(entity);
    }

    @Override
    protected BaseDao<ZonaPunto> getDao(DBHandler handler) {
        return DaoFactory.createZonaPuntoDao(handler);
    }
}
