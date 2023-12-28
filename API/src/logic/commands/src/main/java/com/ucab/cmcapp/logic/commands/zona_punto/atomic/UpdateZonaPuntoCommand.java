package com.ucab.cmcapp.logic.commands.zona_punto.atomic;

import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateZonaPuntoCommand extends UpdateEntityCommand<ZonaPunto> {
    public UpdateZonaPuntoCommand(ZonaPunto entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateZonaPuntoCommand(ZonaPunto entity) {
        super(entity);
    }

    @Override
    protected BaseDao<ZonaPunto> getDao(DBHandler handler) {
        return DaoFactory.createZonaPuntoDao(handler);
    }
}
